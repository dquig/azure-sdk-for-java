/**
 * Copyright Microsoft Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoft.windowsazure.services.servicebus.implementation;

import com.microsoft.windowsazure.core.UserAgentFilter;
import com.microsoft.windowsazure.core.pipeline.PipelineHelpers;
import com.microsoft.windowsazure.core.pipeline.filter.ServiceRequestFilter;
import com.microsoft.windowsazure.core.pipeline.filter.ServiceResponseFilter;
import com.microsoft.windowsazure.core.pipeline.jersey.ClientFilterAdapter;
import com.microsoft.windowsazure.core.pipeline.jersey.ClientFilterRequestAdapter;
import com.microsoft.windowsazure.core.pipeline.jersey.ClientFilterResponseAdapter;
import com.microsoft.windowsazure.core.pipeline.jersey.ServiceFilter;
import com.microsoft.windowsazure.credentials.CertificateCloudCredentials;
import com.microsoft.windowsazure.credentials.CloudCredentials;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.services.servicebus.NamespaceContract;
import com.microsoft.windowsazure.services.servicebus.ServiceBusContract;
import com.microsoft.windowsazure.services.servicebus.models.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.filter.ClientFilter;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class NamespaceRestProxy implements NamespaceContract {

    private Client channel;
    private final String uri;
    private final CustomPropertiesMapper customPropertiesMapper;
    private CertificateCloudCredentials credentials;

    private ClientFilter[] filters;

    @Inject
    public NamespaceRestProxy(Client channel,
                               CertificateCloudCredentials credentials){

        this.channel = channel;
        this.filters = new ClientFilter[0];
        this.customPropertiesMapper = new CustomPropertiesMapper();
        this.uri = credentials.getUri().toString();
        this.credentials = credentials;
    }

    private NamespaceRestProxy(Client channel, ClientFilter[] newFilters, String uri) {
        this.channel = channel;
        this.filters = newFilters;
        this.customPropertiesMapper = new CustomPropertiesMapper();
        this.uri = uri;
    }


    @Override
    public NamespaceContract withFilter(ServiceFilter filter) {
        ClientFilter[] newFilters = Arrays.copyOf(filters, filters.length + 1);
        newFilters[filters.length] = new ClientFilterAdapter(filter);
        return new NamespaceRestProxy(channel, newFilters, uri);
    }

    @Override
    public NamespaceContract withRequestFilterFirst(
            ServiceRequestFilter serviceRequestFilter) {
        ClientFilter[] currentFilters = filters;
        ClientFilter[] newFilters = new ClientFilter[currentFilters.length + 1];
        System.arraycopy(currentFilters, 0, newFilters, 1,
                currentFilters.length);
        newFilters[0] = new ClientFilterRequestAdapter(serviceRequestFilter);
        return new NamespaceRestProxy(channel, newFilters, uri);
    }

    @Override
    public NamespaceContract withRequestFilterLast(
            ServiceRequestFilter serviceRequestFilter) {
        ClientFilter[] currentFilters = filters;
        ClientFilter[] newFilters = Arrays.copyOf(currentFilters,
                currentFilters.length + 1);
        newFilters[currentFilters.length] = new ClientFilterRequestAdapter(
                serviceRequestFilter);
        return new NamespaceRestProxy(channel, newFilters, uri);
    }

    @Override
    public NamespaceContract withResponseFilterFirst(
            ServiceResponseFilter serviceResponseFilter) {
        ClientFilter[] currentFilters = filters;
        ClientFilter[] newFilters = new ClientFilter[currentFilters.length + 1];
        System.arraycopy(currentFilters, 0, newFilters, 1,
                currentFilters.length);
        newFilters[0] = new ClientFilterResponseAdapter(serviceResponseFilter);
        return new NamespaceRestProxy(channel, newFilters, uri);
    }

    @Override
    public NamespaceContract withResponseFilterLast(
            ServiceResponseFilter serviceResponseFilter) {
        ClientFilter[] currentFilters = filters;
        ClientFilter[] newFilters = Arrays.copyOf(currentFilters,
                currentFilters.length + 1);
        newFilters[currentFilters.length] = new ClientFilterResponseAdapter(
                serviceResponseFilter);
        return new NamespaceRestProxy(channel, newFilters, uri);
    }

    public Client getChannel() {
        return channel;
    }

    public void setChannel(Client channel) {
        this.channel = channel;
    }

    private WebResource getResource() {
        WebResource resource = getChannel().resource(uri);
        for (ClientFilter filter : filters) {
            resource.addFilter(filter);
        }
        return resource;
    }

    @Override
    public CreateNamespaceResult createNamespace(NamespaceInfo namespace) {
        Builder webResourceBuilder = getResource()
                .path(credentials.getSubscriptionId())
                .path("/services/ServiceBus/Namespaces/")
                .path(namespace.getPath())
                .header("x-ms-version", "2012-03-01")
                .type("application/atom+xml;type=entry;charset=utf-8");
        return new CreateNamespaceResult(webResourceBuilder.put(NamespaceInfo.class, namespace));
    }
}

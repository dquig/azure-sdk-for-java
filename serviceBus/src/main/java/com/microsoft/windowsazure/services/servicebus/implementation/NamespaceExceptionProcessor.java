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

import com.microsoft.windowsazure.core.pipeline.filter.ServiceRequestFilter;
import com.microsoft.windowsazure.core.pipeline.filter.ServiceResponseFilter;
import com.microsoft.windowsazure.core.pipeline.jersey.ServiceFilter;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.exception.ServiceExceptionFactory;
import com.microsoft.windowsazure.services.servicebus.NamespaceContract;
import com.microsoft.windowsazure.services.servicebus.models.*;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

public class NamespaceExceptionProcessor implements NamespaceContract {

    private final NamespaceContract next;
    private static Log log = LogFactory.getLog(NamespaceContract.class);

    public NamespaceExceptionProcessor(NamespaceContract next) {
        this.next = next;
    }

    @Inject
    public NamespaceExceptionProcessor(NamespaceRestProxy next) {
        this.next = next;
    }

    @Override
    public NamespaceContract withFilter(ServiceFilter filter) {
        return new NamespaceExceptionProcessor(next.withFilter(filter));
    }

    @Override
    public NamespaceContract withRequestFilterFirst(
            ServiceRequestFilter serviceRequestFilter) {
        return new NamespaceExceptionProcessor(
                next.withRequestFilterFirst(serviceRequestFilter));
    }

    @Override
    public NamespaceContract withRequestFilterLast(
            ServiceRequestFilter serviceRequestFilter) {
        return new NamespaceExceptionProcessor(
                next.withRequestFilterLast(serviceRequestFilter));
    }

    @Override
    public NamespaceContract withResponseFilterFirst(
            ServiceResponseFilter serviceResponseFilter) {
        return new NamespaceExceptionProcessor(
                next.withResponseFilterFirst(serviceResponseFilter));
    }

    @Override
    public NamespaceContract withResponseFilterLast(
            ServiceResponseFilter serviceResponseFilter) {
        return new NamespaceExceptionProcessor(
                next.withResponseFilterLast(serviceResponseFilter));
    }

    private ServiceException processCatch(ServiceException e) {
        log.warn(e.getMessage(), e.getCause());
        return ServiceExceptionFactory.process("serviceBus", e);
    }

    @Override
    public CreateNamespaceResult createNamespace(NamespaceInfo namespaceInfo)
            throws ServiceException {
        try {
            return next.createNamespace(namespaceInfo);
        } catch (UniformInterfaceException e) {
            throw processCatch(new ServiceException(e));
        } catch (ClientHandlerException e) {
            throw processCatch(new ServiceException(e));
        }
    }
}

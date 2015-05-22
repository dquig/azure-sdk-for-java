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
package com.microsoft.windowsazure.services.servicebus.models;

import com.microsoft.windowsazure.services.servicebus.implementation.*;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import java.net.URI;

/**
 * Represents a namespace
 */
public class NamespaceInfo extends EntryModel<NamespaceDescription> {

    /**
     * Creates an instance of the <code>EventHubInfo</code> class.
     */
    public NamespaceInfo() {
        super(new Entry(), new NamespaceDescription());
        getEntry().setContent(new Content());
        getEntry().getContent().setType(MediaType.APPLICATION_XML);
        getEntry().getContent().setNamespaceDescription(getModel());
    }

    /**
     * Creates an instance of the <code>NamespaceInfo</code> class using the
     * specified entry.
     *
     * @param entry
     *            An <code>Entry</code> object.
     */
    public NamespaceInfo(Entry entry) {
        super(entry, entry.getContent().getNamespaceDescription());
    }

    /**
     * Creates an instance of the <code>NamespaceInfo</code> class using the
     * specified name.
     *
     * @param path
     *            A <code>String</code> object that represents the name of the
     *            namespace.
     */
    public NamespaceInfo(String path) {
        this();
        setPath(path);
    }

    /**
     * Returns the name of the namespace.
     * 
     * @return A <code>String</code> object that represents the namespace
     */
    public String getPath() {
        return getEntry().getTitle();
    }

    /**
     * Sets the namespace
     * 
     * @param value
     *            A <code>String</code> that represents the namespave.
     * 
     * @return A <code>NamespaceInfo</code> object that represents the updated namespace.
     */
    public NamespaceInfo setPath(String value) {
        getEntry().setTitle(value);
        return this;
    }

    public NamespaceInfo setRegion(Region region) {
        getModel().setRegion(region);
        return this;
    }

    @XmlElement(name = "Region")
    private Region region;
    public Region getRegion() {
        return getModel().getRegion();
    }

    public NamespaceInfo setDefaultKey(String key) {
        getModel().setDefaultKey(key);
        return this;
    }

    public String getDefaultKey() {
        return getModel().getDefaultKey();
    }

    public NamespaceInfo setStatus(NamespaceStatus status) {
        getModel().setStatus(status);
        return this;
    }

    public NamespaceStatus getStatus() {
        return getModel().getStatus();
    }

    public NamespaceInfo setManagementEndpoint(String url) {
        getModel().setAcsManagementEndpoint(url);
        return this;
    }

    public String getManagementEndpoint() {
        return getModel().getAcsManagementEndpoint();
    }

    public NamespaceInfo setServiceBusEndpoint(String url) {
        getModel().setServiceBusEndpoint(url);
        return this;
    }

    public String getServiceBusEndpoint() {
        return getModel().getServiceBusEndpoint();
    }

    public NamespaceInfo setConnectionString(String connectionString) {
        getModel().setConnectionString(connectionString);
        return this;
    }

    public String getConnectionString() {
        return getModel().getConnectionString();
    }

    public NamespaceInfo setType(String type) {
        getModel().setServiceBusEndpoint(type);
        return this;
    }

    public NamespaceType getType() {
        return getModel().getNamespaceType();
    }
}

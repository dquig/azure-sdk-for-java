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

import com.microsoft.windowsazure.services.servicebus.implementation.Content;
import com.microsoft.windowsazure.services.servicebus.implementation.EntityStatus;
import com.microsoft.windowsazure.services.servicebus.implementation.Entry;
import com.microsoft.windowsazure.services.servicebus.implementation.EntryModel;
import com.microsoft.windowsazure.services.servicebus.implementation.EventHubDescription;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import java.net.URI;

/**
 * Represents an event hub.
 */
public class EventHubInfo extends EntryModel<EventHubDescription> {

    /**
     * Creates an instance of the <code>EventHubInfo</code> class.
     */
    public EventHubInfo() {
        super(new Entry(), new EventHubDescription());
        getEntry().setContent(new Content());
        getEntry().getContent().setType(MediaType.APPLICATION_XML);
        getEntry().getContent().setEventHubDescription(getModel());
    }

    /**
     * Creates an instance of the <code>EventHubInfo</code> class using the
     * specified entry.
     *
     * @param entry
     *            An <code>Entry</code> object.
     */
    public EventHubInfo(Entry entry) {
        super(entry, entry.getContent().getEventHubDescription());
    }

    /**
     * Creates an instance of the <code>EventHubInfo</code> class using the
     * specified name.
     *
     * @param path
     *            A <code>String</code> object that represents the name of the
     *            event hub.
     */
    public EventHubInfo(String path) {
        this();
        setPath(path);
    }

    /**
     * Returns the name of the event hub.
     * 
     * @return A <code>String</code> object that represents the name of the
     *         event hub.
     */
    public String getPath() {
        return getEntry().getTitle();
    }

    /**
     * Sets the name of the event hub.
     * 
     * @param value
     *            A <code>String</code> that represents the name of the event hub.
     * 
     * @return A <code>EventHubInfo</code> object that represents the updated
     *         event hub.
     */
    public EventHubInfo setPath(String value) {
        getEntry().setTitle(value);
        return this;
    }

    /**
     * Gets the user metadata.
     * 
     * @return A <code>String</code> objects which contains the user metadata.
     */
    public String getUserMetadata() {
        return getModel().getUserMetadata();
    }

    /**
     * Sets the user metadata.
     * 
     * @param userMetadata
     *            A <code>String</code> objects which contains the user
     *            metadata.
     * @return A <code>EventHubInfo</code> object that represents the updated
     *         queue.
     */
    public EventHubInfo setUserMetadata(String userMetadata) {
        getModel().setUserMetadata(userMetadata);
        return this;
    }

    @XmlElement(name = "MessageRetentionInDays")
    private Integer messageRetentionInDays;
    @XmlElement(name = "Status")
    private EntityStatus status;
    @XmlElement(name = "UserMetadata")
    private String userMetadata;
    @XmlElement(name = "PartitionCount")
    private Integer partitionCount;

    /**
     * Gets the message retention in days.
     *
     * @return An <code>Integer</code> object representing the message
     *         retention in days.
     */
    public Integer getMessageRetentionInDays() {
        return getModel().getMessageRetentionInDays();
    }

    /**
     * Sets the message retention in days
     *
     * @param messageRetentionInDays
     *            An <code>Integer</code> objects which represents the message
     *            retention in days.
     * @return A <code>EventHubInfo</code> object that represents the updated
     *         event hub.
     */
    public EventHubInfo setMessageRetentionInDays(Integer messageRetentionInDays) {
        getModel().setMessageRetentionInDays(messageRetentionInDays);
        return this;
    }

    /**
     * Gets the event hub status.
     *
     * @return An <code>EntityStatus</code> object which represents the event hub status
     */
    public EntityStatus getStatus() {
        return getModel().getStatus();
    }

    /**
     * Sets the event hub status.
     *
     * @param entityStatus
     *            An <code>EntityStatus</code> object which represents the
     *            event hub status
     * @return A <code>EventHubInfo</code> object that represents the updated
     *         event hub.
     */
    public EventHubInfo setStatus(EntityStatus entityStatus) {
        getModel().setUserMetadata(userMetadata);
        return this;
    }

    /**
     * Gets the event hub partition count.
     *
     * @return An <code>Integer</code> objects which represents the partition count
     */
    public Integer getPartitionCount() {
        return getModel().getPartitionCount();
    }

    /**
     * Sets the event hub partition count
     *
     * @param partitionCount
     *            An <code>Integer</code> objects which represents the event hub
     *            partition count.
     * @return A <code>EventHubInfo</code> object that represents the updated
     *         event hub.
     */
    public EventHubInfo setPartitionCount(Integer partitionCount) {
        getModel().setPartitionCount(partitionCount);
        return this;
    }

    /**
     * Sets the URI of the <code>QueueInfo</code> instance.
     * 
     * @param uri
     *            the URI of the <code>QueueInfo</code>
     * 
     * @return A <code>QueueInfo</code> object that represents the updated
     *         queue.
     */
    public EventHubInfo setUri(URI uri) {
        getEntry().setId(uri.toString());
        return this;
    }

    /**
     * Gets the URI of the <code>EventHubInfo</code> instance.
     * 
     * @return A <code>URI</code> representing the <code>EventHubInfo</code>.
     */
    public URI getUri() {
        return URI.create(removeQueryString(getEntry().getId()));
    }

    /**
     * Removes the query string of the URI.
     * 
     * @param uri
     *            A raw string representing the URI of event hub.
     * @return the string
     */
    private String removeQueryString(String uri) {
        String[] result = uri.split("\\?");
        return result[0];
    }
}

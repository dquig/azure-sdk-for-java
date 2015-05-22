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
package com.microsoft.windowsazure.services.servicebus;

import com.microsoft.windowsazure.core.pipeline.jersey.JerseyFilterableService;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.services.servicebus.models.*;

/**
 * 
 * Defines the service bus contract.
 * 
 */
public interface NamespaceContract extends
        JerseyFilterableService<NamespaceContract> {

    /**
     * Creates a serviceHub namespace
     * @param namespace The namespace to create
     * @return Result of createNamespace rest call
     */
    CreateNamespaceResult createNamespace(NamespaceInfo namespace)
        throws ServiceException;

}

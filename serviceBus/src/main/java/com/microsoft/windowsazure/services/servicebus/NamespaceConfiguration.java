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

import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.credentials.CertificateCloudCredentials;

/**
 * Provides functionality to create a service bus configuration.
 *
 */
public abstract class NamespaceConfiguration {

    public static final String SUBSCRIPTION_ID = "subscriptionId";
    public static final String MANAGEMENT_CERTIFICATE = "managementCertificate";

    public static Configuration configureWithCertificate(
            String profile,
            Configuration configuration,
            String subscriptionId,
            CertificateCloudCredentials credentials) {

        configuration.setProperty(profile + SUBSCRIPTION_ID, subscriptionId);
        configuration.setProperty(profile + MANAGEMENT_CERTIFICATE, credentials);
        return configuration;
    }
}

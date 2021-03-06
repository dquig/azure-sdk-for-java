/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.sql;

import com.microsoft.windowsazure.core.FilterableService;
import com.microsoft.windowsazure.credentials.SubscriptionCloudCredentials;
import java.io.Closeable;
import java.net.URI;

/**
* This is the main client class for interacting with the Azure SQL Database
* REST APIs.
*/
public interface SqlManagementClient extends Closeable, FilterableService<SqlManagementClient> {
    /**
    * Gets the API version.
    * @return The ApiVersion value.
    */
    String getApiVersion();
    
    /**
    * Gets the URI used as the base for all cloud service requests.
    * @return The BaseUri value.
    */
    URI getBaseUri();
    
    /**
    * Gets subscription credentials which uniquely identify Microsoft Azure
    * subscription. The subscription ID forms part of the URI for every
    * service call.
    * @return The Credentials value.
    */
    SubscriptionCloudCredentials getCredentials();
    
    /**
    * Gets or sets the initial timeout for Long Running Operations.
    * @return The LongRunningOperationInitialTimeout value.
    */
    int getLongRunningOperationInitialTimeout();
    
    /**
    * Gets or sets the initial timeout for Long Running Operations.
    * @param longRunningOperationInitialTimeoutValue The
    * LongRunningOperationInitialTimeout value.
    */
    void setLongRunningOperationInitialTimeout(final int longRunningOperationInitialTimeoutValue);
    /**
    * Gets or sets the retry timeout for Long Running Operations.
    * @return The LongRunningOperationRetryTimeout value.
    */
    int getLongRunningOperationRetryTimeout();
    
    /**
    * Gets or sets the retry timeout for Long Running Operations.
    * @param longRunningOperationRetryTimeoutValue The
    * LongRunningOperationRetryTimeout value.
    */
    void setLongRunningOperationRetryTimeout(final int longRunningOperationRetryTimeoutValue);
    /**
    * Includes operations for importing and exporting Azure SQL Databases into
    * and out of Azure blob storage.
    * @return The DacOperations value.
    */
    DacOperations getDacOperations();
    
    /**
    * Represents the SQL Database Management API includes operations for
    * managing SQL Server database copies for a subscription.
    * @return The DatabaseCopiesOperations value.
    */
    DatabaseCopyOperations getDatabaseCopiesOperations();
    
    /**
    * The Azure SQL Database Management API includes operations for getting
    * database operations. Specifically, this API allows you to get a specific
    * operation, or to list all the operations that happened on a specific
    * database or on all databases in the Azure SQL Database Server.
    * @return The DatabaseOperationsOperations value.
    */
    DatabaseOperationOperations getDatabaseOperationsOperations();
    
    /**
    * Represents all the operations for operating on Azure SQL Databases.
    * Contains operations to: Create, Retrieve, Update, and Delete databases,
    * and also includes the ability to get the event logs for a database.
    * @return The DatabasesOperations value.
    */
    DatabaseOperations getDatabasesOperations();
    
    /**
    * The Azure SQL Database Management API includes operations for managing
    * the server-level Firewall Rules for Azure SQL Database Servers. You
    * cannot manage the database-level firewall rules using the Azure SQL
    * Database Management API; they can only be managed by running the
    * Transact-SQL statements against the master or individual user databases.
    * @return The FirewallRulesOperations value.
    */
    FirewallRuleOperations getFirewallRulesOperations();
    
    /**
    * The Azure SQL Database Management API includes operations for getting
    * Azure SQL Database Server quotas. Specifically, using the APIs you can
    * get a specific quota or list all of the quotas for the Azure SQL
    * Database Server.
    * @return The QuotasOperations value.
    */
    QuotaOperations getQuotasOperations();
    
    /**
    * Contains operations for getting Azure SQL Databases that can be recovered.
    * @return The RecoverableDatabasesOperations value.
    */
    RecoverableDatabaseOperations getRecoverableDatabasesOperations();
    
    /**
    * Contains the operation to create recovery requests for Azure SQL
    * Databases.
    * @return The RecoverDatabaseOperationsOperations value.
    */
    RecoverDatabaseOperations getRecoverDatabaseOperationsOperations();
    
    /**
    * Contains operations for getting dropped Azure SQL Databases that can be
    * restored.
    * @return The RestorableDroppedDatabasesOperations value.
    */
    RestorableDroppedDatabaseOperations getRestorableDroppedDatabasesOperations();
    
    /**
    * Contains the operation to create restore requests for Azure SQL Databases.
    * @return The RestoreDatabaseOperationsOperations value.
    */
    RestoreDatabaseOperations getRestoreDatabaseOperationsOperations();
    
    /**
    * Contains methods to allow various operations on Azure SQL Database
    * Servers.
    * @return The ServersOperations value.
    */
    ServerOperations getServersOperations();
    
    /**
    * This class provides methods to get a specific service objective by using
    * its ID or to List all of the service objectives on a server.
    * @return The ServiceObjectivesOperations value.
    */
    ServiceObjectiveOperations getServiceObjectivesOperations();
}

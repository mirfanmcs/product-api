Deploy on Azure Container App
==============================

# Step 1

Add following GitHub Action secrets:

|       Name        |                                                                                                                                                                                                                                                          Purpose                                                                                                                                                                                                                                                        |
|:-----------------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| AZURE_CREDENTIALS | The JSON credentials for an Azure subscription. Replace the placeholder values and run the following command to generate the Azure authentication information for this GitHub secret `az ad sp create-for-rbac --name INSERT_SP_NAME --role contributor --scopes /subscriptions/INSERT_SUBSCRIPTION_ID --sdk-auth`. For guidance on adding a secret, [see here](https://docs.microsoft.com/azure/developer/github/connect-from-azure?tabs=azure-portal%2Cwindows#create-a-service-principal-and-add-it-as-a-github-secret) |
|  RESOURCE_GROUP   |                                                                                                                                                                                                                                            The name of resource group to create                                                                                                                                                                                                                                         |
|     LOCATION      |                                                                                                                                                                                                                                                        Azure Region                                                                                                                                                                                                                                                     |
|  ACR_NAME   |                                                                                                                                                                                                                                             Name of Azure Container Registry                                                                                                                                                                                                                                            |
|  CONTAINER_APP_ENVIRONMENT   |                                                                                                   Name of Azure Container App Environment |
|  APP_NAME   |                                                                                                              Container App name    |


# Step 2

Deploy resources to Azure 

Manually trigger GitHub action "Deploy Azure Container App IaC"

# Step 3

Deploy application on Azure Container App.

Manually trigger GitHub action "Build and Deploy Azure Container App" for first time deployment. 

Any update on API will automatically deploy app on new revision in Azure Container App. You can manage revision by following this link: https://learn.microsoft.com/en-us/azure/container-apps/revisions-manage  





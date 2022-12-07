param location string = resourceGroup().location
param uniqueSeed string = '${subscription().subscriptionId}-${resourceGroup().name}'
param uniqueSuffix string = 'da-${uniqueString(uniqueSeed)}'
param containerAppsEnvName string = 'env-${uniqueSuffix}'
param logAnalyticsWorkspaceName string = 'log-${uniqueSuffix}'
param appInsightsName string = 'appinsights-${uniqueSuffix}'
param registryName string
param previousRevision string
//param appName string

@secure()
param registryPassword string

param registryUsername string
param containerImage string
//param viewerImage string


// Log analytics and App Insights for visibility 
resource logAnalyticsWorkspace 'Microsoft.OperationalInsights/workspaces@2020-03-01-preview' = {
  name: logAnalyticsWorkspaceName
  location: location
  properties: any({
    retentionInDays: 30
    features: {
      searchVersion: 1
    }
    sku: {
      name: 'PerGB2018'
    }
  })
}

resource appInsights 'Microsoft.Insights/components@2020-02-02' = {
  name: appInsightsName
  location: location
  kind: 'web'
  properties: {
    Application_Type: 'web'
    WorkspaceResourceId:logAnalyticsWorkspace.id
  }
}

// Container Apps environment 
resource containerAppsEnv 'Microsoft.App/managedEnvironments@2022-03-01' = {
  name: containerAppsEnvName
  location: location
  properties: {
    daprAIInstrumentationKey:appInsights.properties.InstrumentationKey
    appLogsConfiguration: {
      destination: 'log-analytics'
      logAnalyticsConfiguration: {
        customerId: logAnalyticsWorkspace.properties.customerId
        sharedKey: logAnalyticsWorkspace.listKeys().primarySharedKey
      }
    }
  }
}

module productApiapp 'modules/container-app.bicep' = {
  name: '${deployment().name}--productapi'
  dependsOn: [
    containerAppsEnv
  ]
  params: {
    location: location
    containerAppsEnvName: containerAppsEnvName
    appName: 'productapi'
    registryPassword: registryPassword
    registryUsername: registryUsername
    containerImage: containerImage
    httpPort: 8080
    previousRevision: previousRevision
    registryServer: registryName
  }
}

output env array=[
  'Environment name: ${containerAppsEnv.name}'
//  'Storage account name: ${storageAccount.name}'
//  'Storage container name: ${blobContainer.name}'
]

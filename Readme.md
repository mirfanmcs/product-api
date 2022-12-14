product-api
========================
This is the sample REST Spring boot application which can be deployed to any container hosting platform.

This application uses in memory database if no database is attached. You can bind/attach Mysql compatible database at runtime and application will start using that database. No code changes are required to attach the database. 


To build the docker image run following command in the directory where Dockerfile is located:

`$ docker build -t productapi .`

To run the container locally run the following command:

`$ docker run -p 8080:8080 productapi`

To run the container with environment variables:


`$ docker run \
-e APPLICATION_NAME='my app' \
-e COMPANY_NAME='my company' \
-e COMPANY_ADDRESS='my company address' \
-e APPLICATION_SECRET_1='my app secret 1' \
-e APPLICATION_SECRET_2='my app secret 2' \
-p 8080:8080 productapi`


Run following command to build and push image into Azure Container Registry.

`$ az acr build --registry <ACR name> --image productapi .`

Run following command to build container image from Azure Container Registry task. This will create task in Azure container registry and will build image on every commit into GitHub repository.

`az acr task create --registry <ACR name> --name buildproductapi --image productapi --context https://github.com/mirfanmcs/product-api.git --file Dockerfile --git-access-token <access_token>`


Use following URL to access the application:
https://{{base URL}}/api/product

## API Endpoints:

| Method |                Endpoint                |         Description         |
| :---:   |:--------------------------------------:|:---------------------------:|
| GET |              /api/product              |      List all products      |
| GET |           /api/product/{id}            |      Get product by ID      |
| GET | /api/product/productcode/{productCode} | Get product by product code |
| GET |                /api/env                | List environment variables  |
| GET |              /api/health               |    Health check endpoint    |
| GET |               /api/info                |    Show request headers     |
| POST |              /api/product              |     Create new product.     |
| PUT |              /api/product              |       Update product        |
| DELETE |           /api/product/{id}            |    Delete product by ID     |

Sample request body to create product:
```json
{
"code": "ABC",
"shortDescription": "Macbook Pro",
"longDescription": "Macbook Pro, 16G RAM, 1TB SSD",
"productPrice": "2000"
}
```


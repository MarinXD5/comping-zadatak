# comping-zadatak

During a job application for a Java Deceloper at Comping, I was given a project which I had to solve and store in a GitHub repository.
Here is a source code for the given project.

## Instalation

During an installation process of this project, it is neccessary to clone this repository locally. After cloning the repository, you need to open the project in one of IDE's: Intellij, Eclipse, VSC...
After successfully entering the project, you need to run it by clicking on the green arrow to start executing the code.

## API testing

Every API is calling exactly one controller method.

### New data creation

To create new database entries, you need to firstly create a new service provider, because, even though there is a relationship many-to-many, one side has to be the "owning" side. For this project
the Service.java was selected to be the owning side, while the ServiceProvider.java is the non-owning side. In order to create and connect the data in the mid-table, you need to firstly create a
service provider and then the service itself. To create a new service provider you need to call this API:

http://localhost:8080/service-provider (POST REQUEST) and in a request body write:

{
    "providerName": "Some-random-value-string"
}

To create a new service, you need to call this API:

`http://localhost:8080/service/{service_provider_id}` (POST REQUEST) and in the request body write:
`
{
    "serviceDescription": "Some-random-value-string"
}
`

This will create a new Service entity, connect a service with the service provider and add a service provider to the serviceProvider set of the Service entity

If you only want to connect the existing Service and ServiceProvider entities you can do so by calling:

`http://localhost:8080/add-service-provider/{id_service}/{id_provider}` and this will only connect the existing Service and ServiceProvider entities in the join table.

### Data fetching

Fetching either `Service` or `ServiceProvider` is done by calling the:

`http://localhost:8080/services` or `http://localhost:8080/providers` API.

Fetching either one by id is done by calling:

`http://localhost:8080/service/{id}` or `http://localhost:8080/service-provider/{id}`.

###Editing

You can edit data (the already existing and change `Service` - `ServiceProvider` connections) by calling one of these 2 API's:

`http://localhost:8080/service/{service_id}/{existing_provider_id}/{wanted_provider_id}`.

or

`http://localhost:8080/service-provider/{service-provider-id}}`.

###Deleting

Deleting any entry is pretty straightforward. Call the endpoint with the coresponding ID and you will delete the entity with that ID:

`http://localhost:8080/service/{id}`

or

`http://localhost:8080/service-provider/{service-provider-id}}`

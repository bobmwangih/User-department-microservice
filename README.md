# springBoot-microservice

##This is a project made up of 5 microservices:

1.Service registry microservice.(Eureka server).
2.Cloud-config service.(Holds the common configs for all the other microservices in one github file).
3.API-gateway microservice.Acts as the gateway to route requests and responses between microservices.
4.User microservice.Holds crud operations for a user object.Each user belongs to a certain department
5.Department microservice.Holds crud operations for a department service.

### Pre-Usage
Clone the project,
then start the applications in the following order:
```java
1. service-registry
2.cloud-config server
3.api-gateway
4.user-service
5.department-service

####port for running each of the microservice can be changed in the application.properties file

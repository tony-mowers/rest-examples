# Consuming RESTful Web Service

This examples demonstrates how to consume a RESTFul web service. 

It is based upon the Spring guide 
[Consuming a RESTful Web Service](https://spring.io/guides/gs/consuming-rest/).

## Running the Application

You can run the application from the command line.

```
> mvn clean package
> java -jar target/restclient-0.0.1-SNAPSHOT.jar
```

or

```
> ./mvnw spring-boot:run
```

You should see output like:

```
2020-01-28 08:51:28.374  INFO 22652 --- [           main] c.a.e.r.ConsumingRestApplication         : QuoteDTO(type=success, value=ValueDTO(id=9, quote=So easy it is to switch container in #springboot.))
```

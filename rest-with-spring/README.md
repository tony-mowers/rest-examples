# REST Example

Simple REST hello world greeting implemented with Spring Boot.


### Run application using

```
./mvnw spring-boot:run
```

### Using Application via curl 

#### __Greetings__ API Examples

```
curl -H "Accept-Language: fr" http://localhost:8080/greeting?name=Bob
``` 

```
curl http://localhost:8080/greeting/Bob
``` 

#### __Users__ API Examples

Get list of all users
```
curl http://localhost:8080/users
```

Get a single user
```
curl http://localhost:8080/users/2
```

Create a single user
```
curl -i \
-d '{"name" : "Lex Mowers", "birthDate":"2019-10-29T19:58:36.290+0000"}' \
-H "Content-Type: application/json" -X POST http://localhost:8080/users
```
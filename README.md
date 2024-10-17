# Bank
Implementation of a REST API using Spring boot, H2 and Java.

## Dependencies

Spring Web:
Uses Spring MVC, and Apache Tomcat as the default embedded container.

Spring Data JPA SQL:
Java Persistence API using Spring Data and Hibernate plus SQL.

H2 Database:
In-memory DB.


## How to run

Navigate to the bank folder and run command: "./mvnw spring-boot:run"

## Test commands


Test Case 1: Successful Transfer
```
curl -X POST "http://localhost:8080/api/transfer" \
     -d "sourceAccount=1" \
     -d "destinationAccount=2" \
     -d "amount=100.0"

```

Test Case 2: Insufficient Funds
```
curl -X POST "http://localhost:8080/api/transfer" \
     -d "sourceAccount=2" \
     -d "destinationAccount=3" \
     -d "amount=2000.0"
```


Test Case 3: Account Not Found
```
curl -X POST "http://localhost:8080/api/transfer" \
     -d "sourceAccount=99" \
     -d "destinationAccount=1" \
     -d "amount=50.0"
```

-fini-

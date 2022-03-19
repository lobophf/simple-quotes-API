This simple API give to you a way to fetch quotations into JSON format.

To set up and run the server, you need to create a Postgres database and add a file `/src/main/resources/application.properties` which the following content. Don't forget to replace fields like database name, username, and password.

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/{database_name}
spring.datasource.username={user_name}
spring.datasource.password={password}
spring.datasource.driver-class-name =com.mysql.jdbc.Driver
#spring.jpa.show-sql: true
```

Now, access the root project and execute the command below to download the Gradle locally.
```sh 
gradle wrapper
```
Then, run this Gradle task:
```sh
./gradlew bootRun
```

## REST API Methods
You might want to access the endpoints using the following cURL commands.

GET
```sh
http://localhost:8080/api/v1/application
http://localhost:8080/api/v1/application/{id}
http://localhost:8080/api/v1/application/random
```

POST
```sh
curl -X POST -H "Content-Type: application/json" \
	-d '{
		"author": "Erik Naggum",
		"year": "1993",
		"quotationContent": "Life is too long to know C++ well.",
		"urlImgAssociatedWithIt": ""
	    }' \
	    http://localhost:8080/api/v1/application
```

PUT
```sh	    
curl -X PUT -H "Content-Type: application/json" \
	-d '{
		"author": "Robert C. Martin",
		"year": "1993",
		"quotationContent": "Redundant comments are just places to collect lies and misinformation.",
		"urlImgAssociatedWithIt": ""
	}' \
	http://localhost:8080/api/v1/application/1
```

DELETE
```sh
curl -X DELETE http://localhost:8080/api/v1/application/1
```

# spring-cloud-function
Spring Cloud Function to Connect to AWS Lambda

***Dependencies:***
```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-function-adapter-aws</artifactId>
		</dependency>
		<dependency>
			<groupId>com.amazonaws</groupId>
			<artifactId>aws-lambda-java-events</artifactId>
			<version>2.0.2</version>
		</dependency>
		<dependency>
			<groupId>com.amazonaws</groupId>
			<artifactId>aws-lambda-java-core</artifactId>
			<version>1.1.0</version>
			<scope>provided</scope>
		</dependency>
```

***Build Plugins:***
```xml
	<dependency>
		<groupId>org.springframework.boot.experimental</groupId>
		<artifactId>spring-boot-thin-layout</artifactId>
		<version>1.0.10.RELEASE</version>
	</dependency>
```

1. Created a FarenheitCelsiusHandler that extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>
2. FarenheitToCelsius logic is handled in FarenheitToCelsisConvertor by implmenting Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>
3. mvn clean install and generate aws specfic jar (spring-cloud-function-0.0.1-SNAPSHOT-aws.jar)
4. Create a lambda function and add trigger with API Gateway option with all default values and select Java 11 as runtime
5. Upload the jar file and save the lambda. 
6. Copy the <AWS-LAMBDA-URL> from the API Gateway -> Details

***Test:***
curl -X POST -H 'Content-Type:text/plain' <AWS-LAMBDA-URL>/farenheitToCelsius -d '102' -i

HTTP/1.1 200 OK
Date: Thu, 16 Jan 2020 10:21:09 GMT
Content-Type: application/json
Content-Length: 39
Connection: keep-alive

**Converted Celsius : 38.888888888888886**


Reference:
https://github.com/TechPrimers/spring-cloud-function-aws-example

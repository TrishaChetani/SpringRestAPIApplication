## TicketsBooking

- Motivated  to learn and develop rest-endpoint using springboot application

### ToolsUsed

- Springboot : actuator, checkstyle
- Maven
- Docker 
- git
- Jenkins pipeline
- micrometer
- prometheus
- Swagger documentation 

### EndPoint

- GET Ticket

```http://localhost:9090/getTickets```
- POST ticket

```http://localhost:9090/bookTickets```
   
   request body post request
```

	{
		"amount":120,
		"category":"test"
	}

```
- DELETE Ticket
``` 
http://localhost:9090/remove/{{id}}
```
- GET Ticket by Category
``` 
http://localhost:9090/getTicketByCategory/{{category}}
```
### How to Run 
```mvn clean package```
```docker-compose up --force-recreate```

### Monitoring
```http://localhost:9090/actuator```
```http://localhost:9090/actuator/health```
```http://localhost:9090/actuator/prometheus```

### API Swagger Documentation
```http://localhost:9090/swagger-ui.html```

### Checkstyle 
```mvn checkstyle:checkstyle```

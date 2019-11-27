## TicketsBooking

- Motivated to learn and develop CRUD Services using springboot application

### ToolsUsed

- Springboot : actuator, checkstyle
- Maven
- Docker 
- git
- Jenkins pipeline
- micrometer
- prometheus
- Swagger documentation 

### CRUD EndPoint

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
### Build 
```mvn clean package```

### Checkstyle 
```mvn checkstyle:checkstyle```

### How to Run 
```docker-compose up --force-recreate```

### API Swagger Documentation
```http://localhost:9090/swagger-ui.html```

### Monitoring
```http://localhost:9090/actuator```
```http://localhost:9090/actuator/health```
```http://localhost:9090/actuator/prometheus```

#### Prometheus
- Step 1 Pull the images from docker hub
- Step 2  Run the docker image passing the location of prometheus file and image
- Step 3 Open the browser using docker ip address
```docker pull prom/prometheus```
```docker run -p 9090:9090 -v /Users/chetatri/Desktop/spring-mysql/src/main/resources/prometheus.yml prom/prometheus```

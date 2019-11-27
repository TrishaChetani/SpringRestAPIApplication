## TicketsBooking

- Motivated  to learn and develop rest-endpoint using springboot application

### ToolsUsed

- Springboot
- Maven
- docker compose
- git
- Jenkins pipeline

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
```docker-compose up --force-recreate```

### Monitoring
```http://localhost:9090/actuator```
```http://localhost:9090/actuator/health```


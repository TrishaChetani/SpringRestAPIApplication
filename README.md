## TicketsBooking

- Motivated  to learn and develop rest-endpoint using springboot application

### ToolsUsed

- Springboot
- Maven
- docker compose
- git

### EndPoint

- GET Ticket

```http://localhost:9090/ticket/getTickets```
- POST ticket

```http://localhost:9090/ticket/bookTickets```
   
   request body post request
```
[
	{
		"amount":120,
		"category":"test"
	}
]
```
### How to Run 
```docker-compose up --force-recreate```

### Monitoring
```http://localhost:9090/actuator```
```http://localhost:9090/actuator/health```


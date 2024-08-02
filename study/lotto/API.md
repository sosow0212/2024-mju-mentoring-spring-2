- POST 
http://localhost:8080/api/users
```json
{
  "userName": "seungyeop",
  "balance": 10000
}
```



Response

```json

{
  "userId" : 1,
  "userName": "seungyeop",
  "balance": 10000
}
```

--- POST
http://localhost:8080/api/lottos/buy


```json

{
  "userId": "1",
  "ticketCount": 5
}
```


---



- GET 
http://localhost:8080/api/lottos/tickets
```json


{
  "userId": 1,
  "userName": "seungyeop",
  "numbers": "1,14,15,16,32,44,12",
  "isWinner": false
}

```

- GET
http://localhost:8080/api/lottos/winnings

```json


{
  "userId": 1,
  "userName": "seungyeop",
  "ticketCount": 5,
  "totalWinnings" : 0
}

```



http://localhost:8080/api/lottos/tickets?userId=1
```json

{
  "userName": "seungyeop",
  "ticketCount": 5,
  "totalWinnings": 0,
  "balance" : 5000
  }
```


http://localhost:8080/api/lottos/user/allUsers
```json

{
  "userId": 1,
  "userName": "seungyeop",
  "ticketCount": 5,
  "totalWinnings": 0
  }


```

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
  "ticketCount": 2
}
```

--- POST
http://localhost:8080/api/lottos/setWinningNumbers

```json

{
  "winningTicketNumber":"1,2,3,4,5,6"
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
  "lottoPrice": 0
}
```

```json

{
  "userId": 1,
  "userName": "seungyeop",
  "numbers": "1,2,6,21,24,45",
  "lottoPrice": 0
  
}

```


- GET
http://localhost:8080/api/lottos/winnings

```json


{
  "userId": 1,
  "userName": "seungyeop",
  "ticketCount": 2,
  "totalWinnings" : 0
}

```



http://localhost:8080/api/users/userId=1
```json

{
  "userName": "seungyeop",
  "ticketCount": 2,
  "totalWinnings": 0,
  "balance" : 8000
  }
```


http://localhost:8080/api/allUsers
```json

{
  "userId": 1,
  "userName": "seungyeop",
  "ticketCount": 2,
  "totalWinnings": 0
  }


```

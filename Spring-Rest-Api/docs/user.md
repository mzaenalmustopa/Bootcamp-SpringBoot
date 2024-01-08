# User API Spec

## Register User

- Endpoint : POST /api/users

Request Body : 

```json
{
  "username" : "zaenal",
  "password" : "rahasia",
  "name" : "muhamad zaenal mustopa"
}
```

Response Body (Success):

```json
{
  "data" : "OK"
}
```

Response Body (Failed):

```json
{
  "error" : "Username must not blank, ???"
}
```

## Login User

- Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username" : "zaenal",
  "password" : "rahasia"
}
```

Response Body (Success):

```json
{
  "data" : {
    "token" : "TOKEN",
    "expiredAt" : 2342354353 // milliseconds
  }
}
```

Response Body (Failed 401):

```json
{
  "errors" : "Username or password wrong"
}
```

## Get User

- Endpoint : GET /api/users/current

Request Header : 
- X-API-TOKEN : token (Mandatory)

Response Body (Success):

```json
{
  "data" : {
    "username" : "zaenal",
    "name" : "muhamad zaenal mustopa"
  }
}
```

Response Body (Failed 401) :

```json
{
  "errors" : "Unauthorized"
}
```

## Update User

- Endpoint : PUT /api/users/current

Request Header :
- X-API-TOKEN : token (Mandatory)


Request Body : 

```json
{
  "name" : "zaenal mustopa" // put if only want to update
}
```

Response Body (Success):

```json
{
  "data" : {
    "username" : "zaenal",
    "name" : "muhamad zaenal mustopa"
  }
}
```

Response Body (Failed 401):

```json
{
  "errors" : "Unauthorized"
}
```

## Logout User

- Endpoint : DELETE /api/auth/logout

Request Header :
- X-API-TOKEN : token (Mandatory)

Response Body (Success) : 
```json
{
  "data" : "OK"
}
```

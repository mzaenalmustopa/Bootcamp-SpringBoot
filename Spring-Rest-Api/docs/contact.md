# Contact API Spec

## Create Contact

Endpoint : POST /api/contacts

Request Header :
- X-API-TOKEN : token (Mandatory)

Request Body : 

```json
{
  "firstName" : " Muhamad Zaenal",
  "lastname" : "Mustopa",
  "emil" : "zaenal@gmail.com",
  "phone" : "09897777878"
}
```

Response Body (Success):

```json
{
  "data" : {
    "id" : "random-string",
    "firstName" : " Muhamad Zaenal",
    "lastname" : "Mustopa",
    "emil" : "zaenal@gmail.com",
    "phone" : "09897777878"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Email Format Invalid , phone format invalid,  ..."
}
```

## Update Contact

Endpoint : PUT /ap

Request Header :
- X-API-TOKEN : token (Mandatory)

Request Body :
```json
{
  "firstName" : " Muhamad Zaenal",
  "lastname" : "Mustopa",
  "emil" : "zaenal@gmail.com",
  "phone" : "09897777878"
}
```

Response Body (Success):

```json
{
  "data" : {
    "id" : "random-string",
    "firstName" : " Muhamad Zaenal",
    "lastname" : "Mustopa",
    "emil" : "zaenal@gmail.com",
    "phone" : "09897777878"
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "Email Format Invalid , phone format invalid,  ..."
}
```

## Get Contact

Endpoint : GET /api/contacts/{idContact}

Request Header :
- X-API-TOKEN : token (Mandatory) 

Response Body (Success):
```json
{
  "data" : {
    "id" : "random-string",
    "firstName" : " Muhamad Zaenal",
    "lastname" : "Mustopa",
    "emil" : "zaenal@gmail.com",
    "phone" : "09897777878"
  }
}
```

Response Body (Failed 404) :
```json
{
  "errors" : "Contact is Not Found"
}
```

## Search Contact

Endpoint : GET /api/contacts

Request Param :

- name : String, contact first name or last name, using like query, optional
- phone : String, contact phone, using like query, optional
- email : String, contact email, using like query, optional
- page : Integer , start from 0
- size : Integer , default 0

Request Header :
- X-API-TOKEN : token (Mandatory)

Response Body (Success):
```json
{
  "data" : [
    {
      "id" : "random-string",
      "firstName" : " Muhamad Zaenal",
      "lastname" : "Mustopa",
      "emil" : "zaenal@gmail.com",
      "phone" : "09897777878"
    }
  ],
  "page" : {
    "totalPage" : 10,
    "currentPage" : 10,
    "size" : 10
  }
}
```

Response Body (Failed) :
```json
{
  "errors" : "Unauthorized"
}
```

## Remove Contact

Endpoint : DELETE /api/contacts/{idContact}

Request Header :
- X-API-TOKEN : token (Mandatory)

Response Body (Success) :
```json
{
  "data" : "OK"
}
``` 

Response Body (Failed) :

```json
{
  "errors" : "Contact is not found"
}
```
# Address API Spec

## Create Address

Endpoint : POST /api/contacts/{idContact}/address

Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body : 
```json
{
  "street"  : "jalan pamarican",
  "city" : "Ciamis",
  "province" : "jawa barat",
  "country" : "Indonesia",
  "postalCode" : "46588"
}
```

Response Body (Success) :

```json
{
  "data" : {
    "id" : "random-string",
    "street"  : "jalan pamarican",
    "city" : "Ciamis",
    "province" : "jawa barat",
    "country" : "Indonesia",
    "postalCode" : "46588"
  }
}
```

Response Body (Failed) : 

```json
{
  "errors" : "Contact is not found"
}
```


## Update Address

Endpoint : PUT /api/contacts/{idContact}/addresses/{idAddress}

Request Header :
- X-API-TOKEN : Token (Mandatory)


Response Body :
```json
{
  "street"  : "jalan pamarican",
  "city" : "Ciamis",
  "province" : "jawa barat",
  "country" : "Indonesia",
  "postalCode" : "46588"
}
```

Response Body (Success) :

```json
{
  "data" : {
    "id" : "random-string",
    "street"  : "jalan pamarican",
    "city" : "Ciamis",
    "province" : "jawa barat",
    "country" : "Indonesia",
    "postalCode" : "46588"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Address is not found"
}
```

## Get Address

Endpoint : GET /api/contacts/{idContact}/addresses/{idAddress}

Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) :

```json
{
  "data" : {
    "id" : "random-string",
    "street"  : "jalan pamarican",
    "city" : "Ciamis",
    "province" : "jawa barat",
    "country" : "Indonesia",
    "postalCode" : "46588"
  }
}
```

Response Body (Failed) :

```json
{
  "errors" : "Address is not found"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{idContacts}/addresses/{idAddress}

Request Header :
- X-API-TOKEN : Token (Mandatory)

Response Body (Success) : 
```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Address is not found"
}
```

## List Address

Endpoint : GET /api/contacts/{idContacts}/addresses

Request Header :
- X-API-TOKEN : Token (Mandatory)

```json
{
  "data" : [
    {
      "id": "random-string",
      "street": "jalan pamarican",
      "city": "Ciamis",
      "province": "jawa barat",
      "country": "Indonesia",
      "postalCode": "46588"
    }
  ]
}
```

Response Body (Failed) :

```json
{
  "errors" : "Contacts is not found"
}
``` 
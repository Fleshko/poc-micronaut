# mn-atp-mongo

## Testing

### Create Book

```shell
$ curl -i -X POST \
  -H "Content-Type: application/json" \
  -d '{"title": "The Stand", "pages": 454}' \
  localhost:8080/book
```

Sample return value:

```shell
HTTP/1.1 201 Created
date: Wed, 26 Jan 2022 19:11:31 GMT
Content-Type: application/json
content-length: 65
connection: keep-alive

{"id":"61f19db7c83ba32b4ca5a468","title":"The Stand","pages":454}
```

### Update Book

```shell
$ curl -i -X PUT \
  -H "Content-Type: application/json" \
  -d '{"id": "61f19db7c83ba32b4ca5a468", "title": "The Stand", "pages": 555}' \
  localhost:8080/book
```

Sample return value:

```shell
HTTP/1.1 204 No Content
date: Wed, 26 Jan 2022 19:11:03 GMT
connection: keep-alive
```

### Get Books

```shell
$ curl -i localhost:8080/book | jq
```

Sample return value: 

```shell
HTTP/1.1 200 OK
date: Wed, 26 Jan 2022 19:19:29 GMT
Content-Type: application/json
content-length: 199
connection: keep-alive

[
  {
    "id": "61f19db7c83ba32b4ca5a468",
    "title": "The Stand",
    "pages": 555
  }
]
```
### Get Book by Id

```shell
$ curl localhost:8080/book/61f19db7c83ba32b4ca5a468
```

Sample return value:

```shell
HTTP/1.1 200 OK
date: Wed, 26 Jan 2022 19:19:00 GMT
Content-Type: application/json
content-length: 65
connection: keep-alive

{"id":"61f19db7c83ba32b4ca5a468","title":"The Stand","pages":555}
```

### Delete Book

```shell
$ curl -i -X DELETE localhost:8080/book/61f19db7c83ba32b4ca5a468
```

Sample return value:

```shell
HTTP/1.1 204 No Content
date: Wed, 26 Jan 2022 19:20:30 GMT
connection: keep-alive
```
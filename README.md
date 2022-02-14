# mn-atp-mongo

## Testing

### Create Movie

```shell
$ curl -i -X POST \
  -H "Content-Type: application/json" \
  --data-raw '
    {
      "title": "Back to the Future",
      "description": "Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents'\'' first meeting and attracting his mother'\''s romantic interest. Marty must repair the damage to history by rekindling his parents'\'' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.",
      "rating": 83,
      "runtimeMinutes": 126,
      "releasedOn": "07/03/1985"
    }' \
  localhost:8080/movie
```

Sample return value:

```shell
HTTP/1.1 201 Created
date: Mon, 14 Feb 2022 14:20:18 GMT
Content-Type: application/json
content-length: 465
connection: keep-alive

{"id":"620a6521ca65e72ff82ef9ba","title":"Back to the Future","description":"Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents' first meeting and attracting his mother's romantic interest. Marty must repair the damage to history by rekindling his parents' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.","rating":83,"runtimeMinutes":126,"releasedOn":"07/03/1985"}
```

### Update Movie

```shell
$ curl -i -X PUT \
  -H "Content-Type: application/json" \
  --data-raw '
    {
      "id": "620a6521ca65e72ff82ef9ba",
      "title": "Back to the Future",
      "description": "Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents'\'' first meeting and attracting his mother'\''s romantic interest. Marty must repair the damage to history by rekindling his parents'\'' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.",
      "rating": 83,
      "runtimeMinutes": 116,
      "releasedOn": "07/03/1985"
    }' \
  localhost:8080/movie
```

Sample return value:

```shell
HTTP/1.1 204 No Content
date: Mon, 14 Feb 2022 14:23:22 GMT
connection: keep-alive
```

### Get Movies

```shell
$ curl localhost:8080/movie | jq
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
    "id": "620a6521ca65e72ff82ef9ba",
    "title": "Back to the Future",
    "description": "Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents' first meeting and attracting his mother's romantic interest. Marty must repair the damage to history by rekindling his parents' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.",
    "rating": 83,
    "runtimeMinutes": 116,
    "releasedOn": "07/03/1985"
  }
]
```
### Get Movie by Id

```shell
$ curl localhost:8080/movie/620a6521ca65e72ff82ef9ba | jq
```

Sample return value:

```shell
HTTP/1.1 200 OK
date: Wed, 26 Jan 2022 19:19:00 GMT
Content-Type: application/json
content-length: 65
connection: keep-alive

{
  "id": "620a6521ca65e72ff82ef9ba",
  "title": "Back to the Future",
  "description": "Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents' first meeting and attracting his mother's romantic interest. Marty must repair the damage to history by rekindling his parents' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.",
  "rating": 83,
  "runtimeMinutes": 116,
  "releasedOn": "07/03/1985"
}
```

### Delete Movie

```shell
$ curl -i -X DELETE localhost:8080/movie/61f19db7c83ba32b4ca5a468
```

Sample return value:

```shell
HTTP/1.1 204 No Content
date: Mon, 14 Feb 2022 14:25:54 GMT
connection: keep-alive
```

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
$ curl localhost:8080/book | jq
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
$ curl -i localhost:8080/book/61f19db7c83ba32b4ca5a468
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
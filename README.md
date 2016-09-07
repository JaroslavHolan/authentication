# Authentication proxy for Websphere server

- Build project: `mvn clean install`
- Deploy `target/authentication.war` file to **Websphere server**

## How to use

### Request

GET [http://localhost:9080/authentication/user](http://localhost:9080/authentication/user)

### Response

When user is not logged:
```json
    {
       "error":"User is not logged."
    }
```

When user is logged:
```json
    {
       "user":"admin"
    }
```


### Login page

[http://localhost:9080/adminCenter](http://localhost:9080/adminCenter)

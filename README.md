### Instructions to run


In terminal 
. Checkout the  project
```
git clone https://github.com/subban545/cab_trips.git
```

cd to project directory, and run the docker compose
> cd cab_trips
```
docker-compose up
```

######Simple command line client that will consume the APIs provided by the server

**. End point to query cab trips (cached)**
one cab

> curl http://localhost:8080/cab/2013-12-01?id=5D4C105C32FB4E64D50BC8EC88AE4C41

Multiple cabs

> curl http://localhost:8080/cab/2013-12-01?id=5D4C105C32FB4E64D50BC8EC88AE4C41,6CAE8E055C6B5B0017C2669A9E7EF818

. End point to query cab trips (without cache)

one cab

>curl http://localhost:8080/cab/fresh/2013-12-01?id=5D4C105C32FB4E64D50BC8EC88AE4C41

Multiple cabs

> curl http://localhost:8080/cab/fresh/2013-12-01?id=5D4C105C32FB4E64D50BC8EC88AE4C41,6CAE8E055C6B5B0017C2669A9E7EF818

. End point to clear cache

>curl http://localhost:8080/clear-cache

(you can also hit the endpoints in the browser)
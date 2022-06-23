In this application, the Breadth First Search algorithm, which is one of the Graph algorithms, was preferred and this algorithm was integrated into the code.

> Breadth First Search is the algorithm to be used when you want to find the shortest path in an undirected, unweighted graph. The claim of BFS is that when a node is discovered for the first time during migration, it gives the shortest path of that distance from the source.

Unit tests added for BFS algorithm in test folder


#### Used Technology
* Java 11
* Spring Boot
* Maven
* Docker

#### Setup
* Enter folder path of application
* Open terminal and run:
```sh
docker build -t land-route-calculator-app .
```

After application becomes docker image, run this command:

```sh
 docker run -p8080:8080 land-route-calculator-app
 ```
#### Test

| Route | HTTP Verb	 | POST body	 | Description	 |  Response
| --- | --- | --- | --- | --- |
| http://localhost:8080/routes/ITA/TUR | `GET` |  | It will return short path according to  breadth first search algorithm | {"route":["ITA","AUT","HUN","ROU","BGR","TUR"]}

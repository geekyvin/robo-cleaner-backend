##Instructions to Run the Application

cd to project folder [robo-cleaner-backend]

Run the following command to build the project
```console
grade clean build
```
To Execute the Jar application run the following command
```console
java -jar build/libs/marshmellow-0.1.0.jar
```

Open postman and send a post request to run the code

alternatively,

open a new terminal command and run the following command [with required input]

```console
curl -X POST \
http://localhost:8080/api/robot/clean \
  -H 'Content-Type: application/json' \
  -d '{
  "areaSize" : [5, 5],
  "startingPosition" : [1, 2],
  "oilPatches" : [
    [1, 0],
    [2, 2],
    [2, 3]
  ],
  "navigationInstructions" : "NNESEESWNWW"
}’
```

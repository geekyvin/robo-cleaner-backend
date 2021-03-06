
#### This is the solution for the Marshmallow Java Backend Test

### Instruction to pull the repo

```console
git clone git@github.com:geekyvin/robo-cleaner-backend.git
```

### Instructions to Run the Application

cd to project folder [robo-cleaner-backend]

Run the following command to build the project
```console
grade clean build
```
To Execute the Jar application run the following command
```console
java -jar build/libs/marshmellow-0.1.0.jar
```

Open postman and send the below JSON in post request to run the code to http://localhost:8080/api/robot/clean

```console
{
  "areaSize" : [5, 5],
  "startingPosition" : [1, 2],
  "oilPatches" : [
    [1, 0],
    [2, 2],
    [2, 3]
  ],
  "navigationInstructions" : "NNESEESWNWW"
}

```

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

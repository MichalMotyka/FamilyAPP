To create docker file you must use command:
docker build -t familyapp:7.0 .
Before we run container we must create network with command:
docker network create web_server
To run container :
docker run -dit -p 8079:8080 --name familyapp --network web_server -d  familyapp:7.0

request example:
http://localhost:8079/CreateFamily

{
"nrOfAdults":0,
"familyName":"Motyka",
"nrOfInfants":0,
"nrOfChildren":3,
"familyMember":[
{"givenName":"Adam","familyName":"Motyka","age":5},
{"givenName":"Tomasz","familyName":"Motyka","age":5},
{"givenName":"Agata","familyName":"Motyka","age":5}
]
}

http://localhost:8080/getFamily

{
"id":2
}
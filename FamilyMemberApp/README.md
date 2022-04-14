To create docker image we need to use command:
docker build -t familymember:7.0 .
To run container we need to use command:
docker run -p 8080:8081 --name familymember --network web_server --ip 172.18.0.3 -d familymember:7.0

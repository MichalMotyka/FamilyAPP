To create container we need to use command:
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
docker network connect web_server mysql
Next we must to create 2 databases with schema in folder
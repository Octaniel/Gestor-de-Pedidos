#sudo docker-compose down
mvn package -DskipTests
sudo docker build -t gestorpedidos .
sudo docker tag gestorpedidos gestorpedidos
sudo docker-compose up -d

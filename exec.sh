git add .
git commit -m "first commit"
git branch -M 'main'
git remote add origin https://github.com/Octaniel/Gestor-de-Pedidos.git
git push -u origin 'main'

#sudo docker-compose down
#mvn package -DskipTests
#sudo docker build -t gestorpedidos .
#sudo docker tag gestorpedidos gestorpedidos
#sudo docker-compose up -d
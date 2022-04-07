
# Montar Imagem do Mysql
docker build -t compras_db .

# Executar o conteiner do Mysql
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=myroot -e MYSQL_PASSWORD=myroot -e MYSQL_DATABASE=Compras compras_db

#abrir o console do container
docker exec -it bba0e7ceaffe bash 

#abrir o mysql no console
mysql -uroot -p
Enter password: root

#Seleciona o database
use Compras

#Selects
select * from produto;
select * from cliente;
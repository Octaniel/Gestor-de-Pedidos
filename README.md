# Gestor de Pedidos

## Como executar

### Requisitos:

- Docker
- Docker Compose
- Maven

### Execuçao

Para executar a api deve executar o script exec.sh

### Endpoints

- GET /item
- GET /item/{{id}}
- POST /item
    - Exemplo de corpo:
      ```json
      {
      "name": "Banana"
      }
       ```
- PUT /item
- DELETE /item/{{id}}
- GET /order
- GET /order/{{id}}
- POST /order
    - Exemplo de corpo:
    ```json
    {
  "itemId": 1,
  "userId": 1
  }
     ```
- PUT /order
- DELETE /order/{{id}}
- GET /stockMovement
- GET /stockMovement/{{id}}
- POST /stockMovement
    - Exemplo de corpo:
    ```json
    {
  "itemId": 1,
  "quantity": 50.5
  }
     ```
- PUT /stockMovement
- DELETE /stockMovement/{{id}}
- GET /user
- GET /user/{{id}}
- POST /user
    - Exemplo de corpo:
      ```json
      {
      "name": "Octaniel José",
      "email": "otanieljose30@gmail.com"
      }
       ```
- PUT /user
- DELETE /user/{{id}}

#### Observaçao:
 Tem que configurar as seguistes variaveis MAIL_EMAIL_AUTHENTICATION MAIL_PASSWORD_AUTHENTICATION
 MAIL_HOST_NAME no ficheiro docker-compose.yml para o envio de email funcionar.

##### Autor: Octaniel Augusta José
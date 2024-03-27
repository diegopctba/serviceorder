#ServiceOrder

#Libs:
* Spring Boot 2.7.18
* H2 (para conexão com o banco H2)
* Lombok 1.8.32 (Utilizado para diminuir as dependencias de getter e setters)

#Pré Requisitos:
* JDK 11+
* Maven 3.8+
* H2 2.2+


#Configuração
* Clonar projeto (git clone https://github.com/diegopctba/serviceorder.git)

#Banco de dados
1. Realizar download do banco H2 portable (https://github.com/h2database/h2database/releases/download/version-2.2.224/h2-2023-09-17.zip)
2. Descompactar o arquivo e iniciar o banco rodando o arquivo /bin/h2 (.bat para windows ou .sh para linux)

#Executando
* Inicie a execução da classe ServiceOrderApplication (Run As > Java Application)

#Postman
* Há uma collection do postman para testes da API no seguinte caminho:
* ServiceOrder\src\test\ServiceOrder.postman_collection.json
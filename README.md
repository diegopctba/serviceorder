#ServiceOrder

#Pré Requisitos:
* JDK 11+
* Maven 3.8+
* H2 1.4+

#Pontos de atenção
* Ao rodar a aplicação fora de uma IDE (Eclipse), deve-se ter as varáveis de ambiente JAVA_HOME e MAVEN_HOME, apontando para as suas respectivas instalações.

#Configuração
* Caso rode a aplicação à partir do Eclipse, basta importar o projeto tipo maven (Import > Existing Maven Project)
* Caso contrário, rode o comando 'mvn install' na linha de comando à partir da pasta local.

#Banco de dados
1. Após iniciar o banco de dados H2, efetue login na base: jdbc:h2:~/servico
2. Após o logon, copie o conteúdo do arquivo CRUD.sql.
3. Cole o conteúdo copiado na caixa de script do H2 e clique em Run.

#Executando
* Inicie a execução da classe ServiceOrderApplication (Run As > Java Application)

#Postman
* Há uma collection do postman para testes da API no seguinte caminho:
* ServiceOrder\src\test\ServiceOrder.postman_collection.json
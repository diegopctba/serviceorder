DROP TABLE IF EXISTS EVENTO;
DROP TABLE IF EXISTS SERVICO;
DROP TABLE IF EXISTS EQUIPAMENTO;
DROP TABLE IF EXISTS CLIENTE;
DROP TABLE IF EXISTS TECNICO;
DROP SEQUENCE IF EXISTS SEQ_CLIENTE;
DROP SEQUENCE IF EXISTS SEQ_EQUIPAMENTO;
DROP SEQUENCE IF EXISTS SEQ_SERVICO;
DROP SEQUENCE IF EXISTS SEQ_EVENTO;



CREATE TABLE CLIENTE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL,
  telefone VARCHAR(15) NOT NULL,
  endereco VARCHAR(250) DEFAULT NULL,
  cidade VARCHAR(250) DEFAULT NULL,
  uf VARCHAR(2) DEFAULT NULL,
  email VARCHAR(150) NOT NULL
);


CREATE TABLE EQUIPAMENTO (
  id INT AUTO_INCREMENT PRIMARY KEY,
  cliente_id INT NOT NULL,
  serie VARCHAR(50) DEFAULT NULL,
  marca VARCHAR(100) DEFAULT NULL,
  modelo VARCHAR(100) DEFAULT NULL,
  descricao VARCHAR(150) NOT NULL
);

CREATE TABLE TECNICO(
  matricula INT PRIMARY KEY,
  nome VARCHAR(250) NOT NULL
);

CREATE TABLE SERVICO (
  id INT AUTO_INCREMENT PRIMARY KEY,
  cliente_id INT NOT NULL,
  equipamento_id INT NOT NULL,
  tecnico_matricula INT DEFAULT NULL,
  defeito VARCHAR(250) NOT NULL,
  entrada DATETIME NOT NULL,
  entrega DATETIME NULL,
  status CHAR(1) NOT NULL
);

CREATE TABLE EVENTO (
  id INT PRIMARY KEY,
  servico_id INT NOT NULL,
  data DATETIME NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  detalhes VARCHAR(500) NOT NULL
);


ALTER TABLE EQUIPAMENTO
ADD CONSTRAINT FK_EQUIPAMENTO_CLIENTE FOREIGN KEY (cliente_id) REFERENCES CLIENTE;

ALTER TABLE SERVICO
ADD CONSTRAINT FK_SERVICO_CLIENTE FOREIGN KEY (cliente_id) REFERENCES CLIENTE;
ALTER TABLE SERVICO
ADD CONSTRAINT FK_SERVICO_EQUIPAMENTO FOREIGN KEY (equipamento_id) REFERENCES EQUIPAMENTO;
ALTER TABLE SERVICO
ADD CONSTRAINT FK_SERVICO_TECNICO FOREIGN KEY (tecnico_matricula) REFERENCES TECNICO;

ALTER TABLE EVENTO
ADD CONSTRAINT FK_EVENTO_SERVICO FOREIGN KEY (servico_id) REFERENCES SERVICO;

CREATE SEQUENCE SEQ_CLIENTE;
CREATE SEQUENCE SEQ_EQUIPAMENTO;
CREATE SEQUENCE SEQ_SERVICO;
CREATE SEQUENCE SEQ_EVENTO;

INSERT INTO TECNICO VALUES (3341, 'Valentino Silva');
INSERT INTO TECNICO VALUES (87362, 'Leopoldo Munique');
INSERT INTO TECNICO VALUES (76654, 'Pedro Silveira');


INSERT INTO CLIENTE VALUES (NEXTVAL('SEQ_CLIENTE'),'José Eduardo Silva', '47 99872211', 'Rua Arapongas', 'Barra Velha', 'SC', 'jose@jose.com');
INSERT INTO CLIENTE VALUES (NEXTVAL('SEQ_CLIENTE'),'Maria Aparecida', '41 87652211', 'Rua das Andorinhas', 'São José dos Pinhais', 'PR', 'maria@aparecida.com');


INSERT INTO EQUIPAMENTO VALUES (NEXTVAL('SEQ_EQUIPAMENTO'), 1, 'NUM123S','SONY','PLAYSTATION 5', 'VIDEO GAME');

INSERT INTO TECNICO VALUES (1, 'José Maria Santos');

INSERT INTO SERVICO VALUES (NEXTVAL('SEQ_SERVICO'), 1,1,1, 'Equipamento não liga', '2021-06-21', null, 'A');



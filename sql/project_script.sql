DROP TABLE IF EXISTS storico;
DROP TABLE IF EXISTS impiegato;
DROP TABLE IF EXISTS ruolo;

CREATE TABLE impiegato (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50),
  cognome VARCHAR(50),
  
  PRIMARY KEY (id)
);

INSERT INTO impiegato
(nome, cognome)
VALUES 
('ronaldo','nazario');


CREATE TABLE ruolo(
  id INT NOT NULL AUTO_INCREMENT,
  descrizione VARCHAR(255),
  stipendio INT NOT NULL,
  
  PRIMARY KEY (id)
);

INSERT INTO ruolo 
(descrizione, stipendio)
VALUES 
('test descrizione',200);



CREATE TABLE storico (
id INT NOT NULL AUTO_INCREMENT,
idimpiegato INT NOT NULL,
idruolo INT NOT NULL,
matricola INT NOT NULL,
datainizio DATE,
datafine DATE,

PRIMARY KEY (id),
FOREIGN KEY (idimpiegato) REFERENCES impiegato (id),
FOREIGN KEY (idruolo) REFERENCES ruolo(id)
);
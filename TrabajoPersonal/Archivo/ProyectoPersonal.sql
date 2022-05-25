alter session set "_oracle_script"=true;  
create user proyectoPersonal identified by proyectoPersonal;
GRANT CONNECT, RESOURCE, DBA TO proyectoPersonal;



CREATE TABLE pelicula(
	nombre varchar2(100),
	director varchar2(100),
	fechaEstreno DATE,
	genero varchar2(100),
	valoracion number(8),
	estado varchar2(100),
	duracion number(3,2),
	CONSTRAINT pk_pelicula PRIMARY KEY (nombre)
);

CREATE TABLE libro(
	nombre varchar2(100),
	autor varchar2(100),
	fechaEstreno DATE,
	genero varchar2(100),
	valoracion number(8),
	estado varchar2(100),
	capitulos number(8),
	progresoLectura number(8),
	CONSTRAINT pk_libro PRIMARY KEY (nombre)
	
);

CREATE TABLE serie(
	nombre varchar2(100),
	director varchar2(100),
	fechaEstreno DATE,
	genero varchar2(100),
	valoracion number(8),
	estado varchar2(100),
	capitulos number(8),
	progresoSerie number(8),
	CONSTRAINT pk_serie PRIMARY KEY (nombre)
	
);

DELETE FROM PELICULA p 
WHERE p.NOMBRE = 'P';

INSERT INTO PELICULA 
values('P','dasf',NULL,'terror',0,'pendiente',1);
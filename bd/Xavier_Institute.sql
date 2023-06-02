--/*BASE DE DATOS*/
DROP DATABASE IF EXISTS XAVIER_INSTITUTE;
CREATE DATABASE XAVIER_INSTITUTE;
USE XAVIER_INSTITUTE;

  create table tb_alumnos(
  idalumno int auto_increment not null primary key,
  nomalum varchar (45) not null,
  apealum varchar (45) not null,
  dnialum char (8) not null unique,
  fechalum date not null,
  celalum char(9) not null,
  usualum varchar(45) not null unique,
  passalum varchar(6) not null
  );
  alter table tb_alumnos auto_increment=40001;

 create table tb_horarios (
  idhorario int primary key,
  deshorario varchar(15) not null
);

create table tb_profesores(
  idprof int auto_increment not null primary key,
  nomprof varchar (45) not null,
  apeprof varchar (45) not null,
  espeprof varchar (45) not null,
  dniprof char (8) unique not null,
  celprof char(9) not null
  );
  alter table tb_profesores auto_increment=30001;
 
create table tb_cursos(
  idcurso int auto_increment not null primary key,
  nomcurso varchar (45) not null,
  idhorario int references tb_horarios,
  idprof int references tb_profesores
   );
  alter table tb_cursos auto_increment=20001;

create table tb_matriculas(
  idmat int  auto_increment not null primary key,
  fechmat date not null,
  idalumno int not null references tb_alumnos,
  idcurso int not null references tb_cursos,
  idhorario int references tb_horarios,
  idprof int references tb_profesores
  );
  alter table tb_matriculas auto_increment = 90001;
  
insert into tb_horarios values (1,"Mañana");
insert into tb_horarios values (2,"Tarde");
insert into tb_horarios values (3,"Noche");

insert into tb_profesores values (default,"Charles","Xavier","Telequinesis","20632580","123456789");
insert into tb_profesores values (default,"Elizabeth","Braddock ","Psicoquinesis","43635582","123456789");
insert into tb_profesores values (default,"Erik","Lensherr","Magnetismo","42632589","123456789");
insert into tb_profesores values (default,"Raven","Darkhölme","Mimetismo","41632538","123456789");

insert into tb_alumnos values (default,"Anna Marie","D'Ancanto","56325961","2004-10-01","923456739","rogue@xmen.com","111111");
insert into tb_alumnos values (default,"Bobby","Drake","58320963","2003-02-11","998456210","iceman@xmen.com","222222");
insert into tb_alumnos values (default,"Pietro","Maximoff","58320970","2003-03-01","998456233","quicksilver@xmen.com","333333");

insert into tb_cursos values (default,"Telequinesis",1,30001);
insert into tb_cursos values (default,"Psicoquinesis",2,30002);
insert into tb_cursos values (default,"Magnetismo",1,30003);
insert into tb_cursos values (default,"Mimetismo",3,30004);

select*from tb_cursos;
select*from tb_matriculas;
select*from tb_alumnos;
select*from tb_profesores;
select*from tb_horarios;



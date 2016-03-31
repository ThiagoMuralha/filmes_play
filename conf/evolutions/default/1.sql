# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table diretor (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  constraint pk_diretor primary key (id))
;

create table filme (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  tipo                      varchar(255),
  nota                      double,
  duracao                   integer,
  ano                       integer,
  genero                    varchar(255),
  votos                     integer,
  url                       varchar(255),
  constraint pk_filme primary key (id))
;

alter table filme add constraint fk_filme_diretor_1 foreign key (id) references diretor (id) on delete restrict on update restrict;
create index ix_filme_diretor_1 on filme (id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table diretor;

drop table filme;

SET FOREIGN_KEY_CHECKS=1;


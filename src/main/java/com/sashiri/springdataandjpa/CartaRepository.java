package com.sashiri.springdataandjpa;

import org.springframework.data.repository.CrudRepository;

//Vai chamar a base de dados e servir como comunicador direto
//Não precisamos por nenhum tipo de SQL já que existem métodos pra isso
public interface CartaRepository extends CrudRepository<Carta, Long> {

}

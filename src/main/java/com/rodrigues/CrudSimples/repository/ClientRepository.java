package com.rodrigues.CrudSimples.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.rodrigues.CrudSimples.model.ClientModel;

public interface ClientRepository extends CrudRepository<ClientModel, Integer>{

}

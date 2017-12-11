package com.rodrigues.CrudSimples.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.rodrigues.CrudSimples.model.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Integer> {

}

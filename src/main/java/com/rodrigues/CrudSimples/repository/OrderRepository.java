package com.rodrigues.CrudSimples.repository;
import org.springframework.data.repository.CrudRepository;

import com.br.rodrigues.CrudSimples.model.OrderModel;


public interface OrderRepository extends CrudRepository<OrderModel, Integer> {

}

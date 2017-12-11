package com.rodrigues.CrudSimples.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.br.rodrigues.CrudSimples.model.OrderModel;
import com.rodrigues.CrudSimples.repository.OrderRepository;


@CrossOrigin(origins = "*")
@RestController("/order")
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/newOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<OrderModel> newOrder(@RequestBody OrderModel order) {
		try {
			repository.save(order);
			return new ResponseEntity<OrderModel>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/updateOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<OrderModel> updateOrder(@RequestBody OrderModel order) {
		try {
			repository.save(order);
			return new ResponseEntity<OrderModel>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/getAllOrders", produces = "application/json")
	public ResponseEntity<List<OrderModel>> allAnswerComentaryAtt() {
		try {
			List<OrderModel> order = (List<OrderModel>) repository.findAll();
			return new ResponseEntity<List<OrderModel>>(order, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/removeOrder/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<OrderModel> deleteOrder(@PathVariable("id") Integer id) {
		try {
			OrderModel order = repository.findOne(id);
			repository.delete(id);
			return new ResponseEntity<OrderModel>(order, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/findOrder/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<OrderModel> findOneAnswerCommentaryAtt(@PathVariable("id") Integer id) {
		try {
			OrderModel order = repository.findOne(id);
			return new ResponseEntity<OrderModel>(order, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}

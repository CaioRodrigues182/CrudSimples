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
import com.br.rodrigues.CrudSimples.model.ProductModel;
import com.rodrigues.CrudSimples.repository.ProductRepository;

@CrossOrigin(origins = "*")
@RestController("/product")
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/newProduct", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ProductModel> newProduct(@RequestBody ProductModel product) {
		try {
			repository.save(product);
			return new ResponseEntity<ProductModel>(product, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/updateProduct", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel order) {
		try {
			repository.save(order);
			return new ResponseEntity<ProductModel>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/getAllProducts", produces = "application/json")
	public ResponseEntity<List<ProductModel>> allProducts() {
		try {
			List<ProductModel> order = (List<ProductModel>) repository.findAll();
			return new ResponseEntity<List<ProductModel>>(order, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/removeProduct/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ProductModel> deleteProduct(@PathVariable("id") Integer id) {
		try {
			ProductModel order = repository.findOne(id);
			repository.delete(id);
			return new ResponseEntity<ProductModel>(order, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/findProduct/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ProductModel> findOneProduct(@PathVariable("id") Integer id) {
		try {
			ProductModel order = repository.findOne(id);
			return new ResponseEntity<ProductModel>(order, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

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
import com.br.rodrigues.CrudSimples.model.ClientModel;
import com.rodrigues.CrudSimples.repository.ClientRepository;

@CrossOrigin(origins = "*")
@RestController("/client")
public class ClientService {
	
	@Autowired
	ClientRepository repository;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/newClient", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ClientModel> newClient(@RequestBody ClientModel client) {
		try {
			repository.save(client);
			return new ResponseEntity<ClientModel>(client, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/updateClient", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ClientModel> updateClient(@RequestBody ClientModel client) {
		try {
			repository.save(client);
			return new ResponseEntity<ClientModel>(client, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/getAllClients", produces = "application/json")
	public ResponseEntity<List<ClientModel>> allClients() {
		try {
			List<ClientModel> client = (List<ClientModel>) repository.findAll();
			return new ResponseEntity<List<ClientModel>>(client, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/removeClient/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ClientModel> deleteClient(@PathVariable("id") Integer id) {
		try {
			ClientModel client = repository.findOne(id);
			repository.delete(id);
			return new ResponseEntity<ClientModel>(client, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/findClient/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ClientModel> findOneClient(@PathVariable("id") Integer id) {
		try {
			ClientModel client = repository.findOne(id);
			return new ResponseEntity<ClientModel>(client, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}

package com.teste365ti.teste365ti.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste365ti.teste365ti.model.Cliente;
import com.teste365ti.teste365ti.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/telefone/{telefone}")
	public ResponseEntity<List<Cliente>> getByTelefone(@PathVariable String telefone){
		return ResponseEntity.ok(repository.findAllByTelefoneContainingIgnoreCase(telefone));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> post (@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
	}
		
	@PutMapping 
	public ResponseEntity<Cliente> put (@RequestBody Cliente cliente){
		return ResponseEntity.ok(repository.save(cliente));
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable Long id){
		repository.deleteById(id);
	}
		
	


}

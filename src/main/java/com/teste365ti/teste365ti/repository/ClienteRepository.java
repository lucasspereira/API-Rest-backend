package com.teste365ti.teste365ti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste365ti.teste365ti.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public List<Cliente> findAllByTelefoneContainingIgnoreCase (String telefone);
}

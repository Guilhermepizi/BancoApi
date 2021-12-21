package br.com.service.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.service.banco.model.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

	Conta findByIdConta(Long idConta);
	
}

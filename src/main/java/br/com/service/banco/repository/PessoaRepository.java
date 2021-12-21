package br.com.service.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.service.banco.model.entity.Conta;
import br.com.service.banco.model.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Conta findByIdPessoa(Long idPessoa);
	
}

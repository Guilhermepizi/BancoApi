package br.com.service.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.service.banco.model.entity.Extrato;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Long>{

	List<Extrato> findAllByIdConta(Integer idConta);
}

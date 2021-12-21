package br.com.service.banco.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Builder;
import lombok.Data;


@Entity
@Builder
@Data
public class Conta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idConta;
	
	@OneToOne
    public Long idPessoa;
	
    public BigDecimal saldo;
    public BigDecimal limiteSaqueDiario;
    public Boolean flagAtivo;
    public Integer tipoConta;
    public LocalDateTime dataCriacao;

}

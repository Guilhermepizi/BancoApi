package br.com.service.banco.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;


@Entity
@Builder
@Data
public class Extrato{
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idTransacao;
	public Long idConta;
    public BigDecimal valor;
    public LocalDateTime dataTransacao;
    public BigDecimal saldo;
}

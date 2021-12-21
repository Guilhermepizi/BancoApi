package br.com.service.banco.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.service.banco.model.entity.Conta;
import br.com.service.banco.service.ContaService;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idConta",
    "idPessoa",
    "saldo",
    "limiteSaqueDiario",
    "flagAtivo",
    "tipoConta",
    "dataCriacao"
})
@Generated("jsonschema2pojo")
@Data
public class ContaDTO {

    @JsonProperty("idPessoa")
    public Long idPessoa;
    @JsonProperty("saldo")
    public BigDecimal saldo;
    @JsonProperty("limiteSaqueDiario")
    public BigDecimal limiteSaqueDiario;
    @JsonProperty("tipoConta")
    public Integer tipoConta;

    
    public Conta criarEntityConta(ContaService contaService) {
    	
    	LocalDateTime dataCriacao = LocalDateTime.now();
    	
    	contaService.verificaPessoa(idPessoa);
    	
    	return Conta.builder()
    			.idPessoa(idPessoa)
    			.saldo(saldo)
    			.limiteSaqueDiario(limiteSaqueDiario)
    			.flagAtivo(true)
    			.tipoConta(tipoConta)
    			.dataCriacao(dataCriacao)
    			.build();
    }
}

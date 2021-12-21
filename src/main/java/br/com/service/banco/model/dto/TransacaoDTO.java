
package br.com.service.banco.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.service.banco.model.entity.Extrato;
import br.com.service.banco.service.ContaService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idTransacao",
    "idConta",
    "valor",
    "dataTransacao"
})
@Generated("jsonschema2pojo")
public class TransacaoDTO {

    @JsonProperty("idConta")
    public Long idConta;
    @JsonProperty("valor")
    public BigDecimal valor;
    @JsonProperty("dataTransacao")
    public LocalDateTime dataTransacao;
   

    public Extrato criarEntityExtrato(ContaService contaService) {
    	BigDecimal saldo = contaService.getSaldo(idConta);
    	return Extrato.builder()
    			.idTransacao(idConta)
    			.idConta(idConta)
    			.valor(valor)
    			.dataTransacao(dataTransacao)
    			.saldo(saldo)
    			.build();
    }
}

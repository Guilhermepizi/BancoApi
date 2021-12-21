
package br.com.service.banco.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;

@Entity
@Builder
public class Pessoa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
	public Long idPessoa;
    public String nome;
    public String cpf;
    public LocalDateTime dataNascimento;
}

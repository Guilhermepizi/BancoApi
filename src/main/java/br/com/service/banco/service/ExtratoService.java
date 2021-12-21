package br.com.service.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.service.banco.model.dto.TransacaoDTO;
import br.com.service.banco.model.entity.Extrato;
import br.com.service.banco.repository.ExtratoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ExtratoService {
	
	@Autowired
	private ExtratoRepository extratoRepository;	
	
	@Autowired
	private ContaService contaService;
	
	public Extrato adicionaTransacaoExtrato(TransacaoDTO transacaoDTO) {		
		Extrato extrato = transacaoDTO.criarEntityExtrato(contaService);
		return extratoRepository.save(extrato);
	}
	
	public List<Extrato> historicoTransacao(Integer idConta){
		return extratoRepository.findAllByIdConta(idConta);
	}
}

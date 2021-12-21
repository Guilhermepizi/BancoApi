package br.com.service.banco.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.service.banco.advisor.EntityNotFoundException;
import br.com.service.banco.model.entity.Conta;
import br.com.service.banco.repository.ContaRepository;
import br.com.service.banco.repository.ExtratoRepository;
import br.com.service.banco.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void criaConta(Conta conta) {
		contaRepository.save(conta);
	}

	public void depositoConta(Long idConta, BigDecimal valorDeposito) {	
		Conta conta;
		try {
			conta = contaRepository.findByIdConta(idConta);
		}catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Conta nao encontrada");
		}
		BigDecimal saldoAtual = conta.getSaldo();
		BigDecimal novoSaldo = saldoAtual.add(valorDeposito);
		conta.setSaldo(novoSaldo);
		contaRepository.save(conta);
	
	}

	public void saqueConta(Long idConta, BigDecimal valorSaque) {
		Conta conta;
		try {
			conta = contaRepository.findByIdConta(idConta);
		}catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Conta nao encontrada");
		}
		BigDecimal saldoAtual = conta.getSaldo();
		BigDecimal novoSaldo = saldoAtual.subtract(valorSaque);
		conta.setSaldo(novoSaldo);
		contaRepository.save(conta);
	}

	public BigDecimal getSaldo(Long idConta) {
		Conta conta;
		try {
			conta = contaRepository.findByIdConta(idConta);
		}catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Conta nao encontrada");
		}
		return conta.getSaldo();
	}

	public Conta bloqueiaConta(Long idConta) {
		Conta conta;
		try {
			conta = contaRepository.findByIdConta(idConta);
		}catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Conta nao encontrada");
		}
		conta.setFlagAtivo(false);
		return contaRepository.save(conta);
	}

	public void verificaPessoa(Long idPessoa) {
		try {
			pessoaRepository.findByIdPessoa(idPessoa);
		}catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Pessoa nao encontrada");
		}
	}
}
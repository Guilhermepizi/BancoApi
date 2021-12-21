package br.com.service.banco.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.banco.model.dto.ContaDTO;
import br.com.service.banco.model.dto.TransacaoDTO;
import br.com.service.banco.model.entity.Conta;
import br.com.service.banco.model.entity.Extrato;
import br.com.service.banco.service.ContaService;
import br.com.service.banco.service.ExtratoService;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/bancoenterprise")
public class BancoController {

	@Autowired
	ContaService contaService;

	@PostMapping("/criarconta")
	public ResponseEntity<Void> criarConta(
			@ApiParam("Informações da conta para uma nova conta ser criada.") @RequestBody ContaDTO contaDTO) {
		
		contaService.criaConta(contaDTO.criarEntityConta(contaService));
		
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@Autowired
	ExtratoService extratoService;

	@PostMapping("/realizadeposito")
	public ResponseEntity<Extrato> realizaDeposito(
			@ApiParam("Operacao para a realizacao de deposito.") @RequestBody TransacaoDTO deposito) {
		contaService.depositoConta(deposito.getIdConta(), deposito.getValor());
		Extrato extrato = extratoService.adicionaTransacaoExtrato(deposito);
		return new ResponseEntity<>(extrato, HttpStatus.CREATED);
	}

	@PostMapping("/realizasaque")
	public ResponseEntity<Extrato> realizaSaque(
			@ApiParam("Operacao para a realizacao de deposito.") @RequestBody TransacaoDTO saque) {
		
		contaService.saqueConta(saque.getIdConta(), saque.getValor());
		Extrato extrato = extratoService.adicionaTransacaoExtrato(saque);
		return new ResponseEntity<>(extrato, HttpStatus.CREATED);
	}

	@GetMapping("/consultasaldo")
	public ResponseEntity<BigDecimal> consultaSaldo(
			@ApiParam("Operacao para a realizacao de deposito.") @RequestParam Long idConta) {
		BigDecimal saldo = contaService.getSaldo(idConta);
		return new ResponseEntity<>(saldo, HttpStatus.OK);
	}

	@GetMapping("/extrato")
	public ResponseEntity<List<Extrato>> extratoConta(
			@ApiParam("Operacao para a realizacao de deposito.") @RequestParam Integer idConta) {
		List<Extrato> transacoes = extratoService.historicoTransacao(idConta);
		return new ResponseEntity<>(transacoes, HttpStatus.CREATED);
	}

	@PutMapping("/bloqueio")
	public ResponseEntity<Conta> bloqueiaConta(
			@ApiParam("Operacao para a realizacao de deposito.") @RequestParam Long idConta) {
		Conta conta = contaService.bloqueiaConta(idConta);
		return new ResponseEntity<>(conta, HttpStatus.CREATED);
	}

}

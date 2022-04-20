package br.com.leilao.servico;

import java.math.BigDecimal;

import br.com.leilao.dominio.Leilao;

public class Avaliador {
	private BigDecimal maiorLance = new BigDecimal("-1");
	private BigDecimal menorLance = new BigDecimal("999");

	public void avaliaLances(Leilao leilao) {
		leilao.getLances().forEach(item -> {
			if(item.getValor().compareTo(maiorLance) >= 1) {
				maiorLance = item.getValor();
			}
			if(item.getValor().compareTo(menorLance) < 0) {
				menorLance = item.getValor();
			}
		});
	}
	
	public BigDecimal getMaiorLance() {
		return maiorLance;
	}
	
	public BigDecimal getMenorLance() {
		return menorLance;
	}
}

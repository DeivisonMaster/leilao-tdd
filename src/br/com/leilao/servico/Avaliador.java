package br.com.leilao.servico;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;

public class Avaliador {
	private BigDecimal maiorLance = new BigDecimal("-1");
	private BigDecimal menorLance = new BigDecimal("99999");
	private List<Lance> maiores;

	public void avaliaLances(Leilao leilao) {
		leilao.getLances().forEach(item -> {
			if(item.getValor().compareTo(maiorLance) >= 1) {
				maiorLance = item.getValor();
			}
			if(item.getValor().compareTo(menorLance) < 0) {
				menorLance = item.getValor();
			}
		});
		
		maiores = new ArrayList<>(leilao.getLances());
		Collections.sort(maiores, new Comparator<Lance>() {
			@Override
			public int compare(Lance l1, Lance l2) {
				if(l1.getValor().compareTo(l2.getValor()) < 1)
					return 1;
				if(l1.getValor().compareTo(l2.getValor()) >= 1)
					return -1;
				return 0;
			}
		});
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}
	
	public BigDecimal getMaiorLance() {
		return maiorLance;
	}
	
	public BigDecimal getMenorLance() {
		return menorLance;
	}
	
	public List<Lance> getTresMaioresLances() {
		return maiores;
	}
}

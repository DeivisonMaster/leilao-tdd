package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;
import br.com.leilao.dominio.Usuario;
import br.com.leilao.servico.Avaliador;

public class TesteAvaliador {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// cenário
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario jose = new Usuario("José");
		
		Leilao leilaoDeVeiculos = new Leilao("Carros usados");
		leilaoDeVeiculos.propoe(new Lance(joao, new BigDecimal("300.0")));
		leilaoDeVeiculos.propoe(new Lance(jose, new BigDecimal("100.0")));
		leilaoDeVeiculos.propoe(new Lance(jose, new BigDecimal("400.0")));
		leilaoDeVeiculos.propoe(new Lance(maria, new BigDecimal("250.0")));
		leilaoDeVeiculos.propoe(new Lance(joao, new BigDecimal("550.0")));
		leilaoDeVeiculos.propoe(new Lance(maria, new BigDecimal("10.0")));
		
		// ação
		Avaliador avaliador = new Avaliador();
		avaliador.avaliaLances(leilaoDeVeiculos);
		
		// validação
		BigDecimal maiorEsperado = new BigDecimal("550.0");
		assertEquals(maiorEsperado, avaliador.getMaiorLance());
		
		BigDecimal menorEsperado = new BigDecimal("10.0");
		assertEquals(menorEsperado, avaliador.getMenorLance());
	}
}

package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

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
		leilaoDeVeiculos.propoe(new Lance(jose, new BigDecimal("400.0")));
		leilaoDeVeiculos.propoe(new Lance(maria, new BigDecimal("250.0")));
		
		// ação
		Avaliador avaliador = new Avaliador();
		avaliador.avaliaLances(leilaoDeVeiculos);
		
		// validação
		BigDecimal maiorEsperado = new BigDecimal("400.0");
		assertEquals(maiorEsperado, avaliador.getMaiorLance());
		
		BigDecimal menorEsperado = new BigDecimal("250.0");
		assertEquals(menorEsperado, avaliador.getMenorLance());
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Usuario joao = new Usuario("João");
		
		Leilao leilaoVeiculo = new Leilao("Leilão de Veiculos");
		leilaoVeiculo.propoe(new Lance(joao, new BigDecimal("1000.0")));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avaliaLances(leilaoVeiculo);
		
		BigDecimal maiorEsperado = new BigDecimal("1000.0");
		assertEquals(maiorEsperado, avaliador.getMaiorLance());
		
		BigDecimal menorEsperado = new BigDecimal("1000.0");
		assertEquals(menorEsperado, avaliador.getMenorLance());
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario jose = new Usuario("José");
		
		Leilao leilaoDeVeiculos = new Leilao("Carros usados");
		leilaoDeVeiculos.propoe(new Lance(joao, new BigDecimal("900.0")));
		leilaoDeVeiculos.propoe(new Lance(jose, new BigDecimal("400.0")));
		leilaoDeVeiculos.propoe(new Lance(maria, new BigDecimal("130.0")));
		leilaoDeVeiculos.propoe(new Lance(maria, new BigDecimal("1000.0")));
		leilaoDeVeiculos.propoe(new Lance(jose, new BigDecimal("750.0")));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avaliaLances(leilaoDeVeiculos);
		
		List<Lance> tresMaioresLances = avaliador.getTresMaioresLances();
		assertEquals(3, tresMaioresLances.size());
		assertEquals(new BigDecimal("1000.0"), tresMaioresLances.get(0).getValor());
		assertEquals(new BigDecimal("900.0"), tresMaioresLances.get(1).getValor());
		assertEquals(new BigDecimal("750.0"), tresMaioresLances.get(2).getValor());
		
		tresMaioresLances.forEach(lance -> {
			System.out.println(lance.getValor());
		});
	}
	
}

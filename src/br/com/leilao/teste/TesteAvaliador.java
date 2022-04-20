package br.com.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.leilao.builder.LeilaoBuilder;
import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;
import br.com.leilao.dominio.Usuario;
import br.com.leilao.servico.Avaliador;

public class TesteAvaliador {
	private Avaliador avaliador;
	private Usuario joao;
	private Usuario maria;
	private Usuario jose;
	
	@Before
	public void criaAvaliador() {
		avaliador = new Avaliador();
		joao = new Usuario("João");
		maria = new Usuario("Maria");
		jose = new Usuario("José");
	}
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// cenário
		Leilao leilaoDeVeiculos = new LeilaoBuilder()
				.para("Playstation 4 novo")
				.lance(joao, new BigDecimal("300.0"))
				.lance(jose, new BigDecimal("400.0"))
				.lance(maria, new BigDecimal("250.0"))
				.build();
		
		// ação
		avaliador.avaliaLances(leilaoDeVeiculos);
		
		// validação
		BigDecimal maiorEsperado = new BigDecimal("400.0");
		assertEquals(maiorEsperado, avaliador.getMaiorLance());
		
		BigDecimal menorEsperado = new BigDecimal("250.0");
		assertEquals(menorEsperado, avaliador.getMenorLance());
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Leilao leilaoVeiculo = new LeilaoBuilder()
				.para("Leilão de Veiculos")
				.lance(joao, new BigDecimal("1000.0"))
				.build();
		
		avaliador.avaliaLances(leilaoVeiculo);
		
		BigDecimal maiorEsperado = new BigDecimal("1000.0");
		assertEquals(maiorEsperado, avaliador.getMaiorLance());
		
		BigDecimal menorEsperado = new BigDecimal("1000.0");
		assertEquals(menorEsperado, avaliador.getMenorLance());
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Leilao leilaoDeVeiculos = new LeilaoBuilder()
				.para("Carros Usados")
				.lance(joao, new BigDecimal("900.0"))
				.lance(jose, new BigDecimal("400.0"))
				.lance(maria, new BigDecimal("130.0"))
				.lance(maria, new BigDecimal("1000.0"))
				.lance(jose, new BigDecimal("750.0"))
				.build();
		
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

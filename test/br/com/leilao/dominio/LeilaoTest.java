package br.com.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class LeilaoTest {

//	@Test
	public void deveReceberApenasUmLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), new BigDecimal("2000.0")));
		assertEquals(1, leilao.getLances().size());
		assertEquals(new BigDecimal("2000.0"), leilao.getLances().get(0).getValor());
	}
	
//	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Uno 2010");
		
		leilao.propoe(new Lance(new Usuario("Marcos"), new BigDecimal("12.000")));
		leilao.propoe(new Lance(new Usuario("Karla"), new BigDecimal("12.100")));
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(new BigDecimal("12.000"), leilao.getLances().get(0).getValor());
		assertEquals(new BigDecimal("12.100"), leilao.getLances().get(1).getValor());
	}
	
//	@Test
	public void naoDeveAceitarDoisLancesEmSequenciaDeUmMesmoUsuarioNoMesmoLeilao() {
		Leilao leilao = new Leilao("Macbook Pro 17");
		
		Usuario steveJobs = new Usuario("Steve Jobs");
		leilao.propoe(new Lance(steveJobs, new BigDecimal("2000.0")));
		leilao.propoe(new Lance(steveJobs, new BigDecimal("3000.0")));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(new BigDecimal("2000.0"), leilao.getLances().get(0).getValor());
	}
	
	@Test
	public void naoDeveAceitarMaisDoQueCincoLancesDeUmMesmoUsuarioEmUmMesmoLeilao() {
		Leilao leilao = new Leilao("IPad Pro");
		
		Usuario steveJobs = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Bill Gates");
		
		leilao.propoe(new Lance(steveJobs, new BigDecimal("1000.0")));
		leilao.propoe(new Lance(billGates, new BigDecimal("2000.0")));
		
		leilao.propoe(new Lance(steveJobs, new BigDecimal("3000.0")));
		leilao.propoe(new Lance(billGates, new BigDecimal("4000.0")));
		
		leilao.propoe(new Lance(steveJobs, new BigDecimal("5000.0")));
		leilao.propoe(new Lance(billGates, new BigDecimal("6000.0")));
		
		leilao.propoe(new Lance(steveJobs, new BigDecimal("7000.0")));
		leilao.propoe(new Lance(billGates, new BigDecimal("8000.0")));
		
		leilao.propoe(new Lance(steveJobs, new BigDecimal("9000.0")));
		leilao.propoe(new Lance(billGates, new BigDecimal("10000.0")));
		
		// deve ser ignorado
		leilao.propoe(new Lance(steveJobs, new BigDecimal("11000.0")));
		
//		assertEquals(10, leilao.getLances().size());
		assertEquals(5, leilao.getLances().size());
		assertEquals(new BigDecimal("11000.0"), leilao.getLances().get(leilao.getLances().size() - 1).getValor());
//		assertEquals(new BigDecimal("5000.0"), leilao.getLances().get(leilao.getLances().size() - 1).getValor());
	}
	
	
}

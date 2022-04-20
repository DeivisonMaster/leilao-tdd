package br.com.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class LeilaoTest {

	@Test
	public void deveReceberApenasUmLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), new BigDecimal("2000.0")));
		assertEquals(1, leilao.getLances().size());
		assertEquals(new BigDecimal("2000.0"), leilao.getLances().get(0).getValor());
	}
	
	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Uno 2010");
		
		leilao.propoe(new Lance(new Usuario("Marcos"), new BigDecimal("12.000")));
		leilao.propoe(new Lance(new Usuario("Karla"), new BigDecimal("12.100")));
		
		assertEquals(2, leilao.getLances().size());
		assertEquals(new BigDecimal("12.000"), leilao.getLances().get(0).getValor());
		assertEquals(new BigDecimal("12.100"), leilao.getLances().get(1).getValor());
	}
	
}

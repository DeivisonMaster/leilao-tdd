package br.com.caelum.leilao.teste;

import java.math.BigDecimal;

import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;
import br.com.leilao.dominio.Usuario;
import br.com.leilao.servico.Avaliador;

public class TesteAvaliador {
	public static void main(String[] args) {
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario jose = new Usuario("José");
		
		Leilao leilaoDeVeiculos = new Leilao("Carros usados");
		leilaoDeVeiculos.propoe(new Lance(joao, new BigDecimal("300.0")));
		leilaoDeVeiculos.propoe(new Lance(jose, new BigDecimal("100.0")));
		leilaoDeVeiculos.propoe(new Lance(jose, new BigDecimal("400.0")));
		leilaoDeVeiculos.propoe(new Lance(maria, new BigDecimal("250.0")));
		leilaoDeVeiculos.propoe(new Lance(joao, new BigDecimal("550.0")));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avaliaLances(leilaoDeVeiculos);
		
		System.out.println("maior: " + avaliador.getMaiorLance());
		System.out.println("menor: " + avaliador.getMenorLance());
	}
}

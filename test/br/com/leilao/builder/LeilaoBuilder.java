package br.com.leilao.builder;

import java.math.BigDecimal;

import br.com.leilao.dominio.Lance;
import br.com.leilao.dominio.Leilao;
import br.com.leilao.dominio.Usuario;

public class LeilaoBuilder {
	private Leilao leilao;
	private Lance lance;
	
	public LeilaoBuilder para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public LeilaoBuilder lance(Usuario usuario, BigDecimal valor) {
		this.leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao build() {
		return leilao;
	}
	
}

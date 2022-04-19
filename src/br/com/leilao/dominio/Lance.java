package br.com.leilao.dominio;

import java.math.BigDecimal;

public class Lance {
	private Usuario usuario;
	private BigDecimal valor;
	
	public Lance() {
	}
	
	public Lance(Usuario usuario, BigDecimal valor) {
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
}

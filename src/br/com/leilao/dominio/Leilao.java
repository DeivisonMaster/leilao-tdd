package br.com.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {
	private String descricao;
	private List<Lance> lances;
	private int total = 0;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		total = quantidadeDeLancesDo(lance.getUsuario());
		
		if(lances.isEmpty() || (!ultimoLanceInformado().getUsuario().equals(lance.getUsuario()) && total < 5)) {
			lances.add(lance);
		}
	}

	private int quantidadeDeLancesDo(Usuario usuario) {
		for (Lance item : lances) {
			if(item.getUsuario().equals(usuario)) {
				total++;
			}
		}
		return total;
	}

	private Lance ultimoLanceInformado() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	
	
}

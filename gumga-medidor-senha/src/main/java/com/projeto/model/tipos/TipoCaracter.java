package com.projeto.model.tipos;

import com.projeto.regras.RegraCalculoCaracteres;
import com.projeto.validacoes.ContadorCaracteresMaiusculos;
import com.projeto.validacoes.ContadorCaracteresMinusculos;
import com.projeto.validacoes.ContadorCaracteresNumerico;
import com.projeto.validacoes.ContadorCaracteresSimbolos;

public enum TipoCaracter {

	MAIUSCULO(new ContadorCaracteresMaiusculos()),
	NUMERICO(new ContadorCaracteresNumerico()),
	MINUSCULO(new ContadorCaracteresMinusculos()), 
	SIMBOLO(new ContadorCaracteresSimbolos());

	private RegraCalculoCaracteres regra;

	private TipoCaracter(RegraCalculoCaracteres regra) {
		this.regra = regra;

	}

	public RegraCalculoCaracteres getRegra() {
		return regra;
	}

	public void setRegra(RegraCalculoCaracteres regra) {
		this.regra = regra;
	}

}

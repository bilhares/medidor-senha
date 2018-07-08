package com.projeto.model;

import com.projeto.model.tipos.TipoCaracter;

public class CaracterSimbolos extends Caracter {

	private int nCaracterMedio;

	public CaracterSimbolos() {
		this.tipo = TipoCaracter.SIMBOLO;
	}

	public int getnCaracterMedio() {
		return nCaracterMedio;
	}

	public void setnCaracterMedio(int nCaracterMedio) {
		this.nCaracterMedio = nCaracterMedio;
	}

}

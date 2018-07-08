package com.projeto.model;

import com.projeto.model.tipos.TipoCaracter;

public class CaracterNumericos extends Caracter {

	private int nCaracterMedio;

	public CaracterNumericos() {
		this.tipo = TipoCaracter.NUMERICO;
	}

	public int getnCaracterMedio() {
		return nCaracterMedio;
	}

	public void setnCaracterMedio(int nCaracterMedio) {
		this.nCaracterMedio = nCaracterMedio;
	}

}

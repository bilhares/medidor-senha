package com.projeto.model;

import com.projeto.model.tipos.TipoCaracter;
import com.projeto.regras.RegraCaracteres;

public class Caracter implements RegraCaracteres {

	TipoCaracter tipo;
	int nCaracteres;
	int nCaracteresConsecutivos;

	public TipoCaracter getTipo() {
		return tipo;
	}

	public void setTipo(TipoCaracter tipo) {
		this.tipo = tipo;
	}

	public int getnCaracteres() {
		return nCaracteres;
	}

	public void setnCaracteres(int nCaracteres) {
		this.nCaracteres = nCaracteres;
	}

	public int getnCaracteresConsecutivos() {
		return nCaracteresConsecutivos;
	}

	public void setnCaracteresConsecutivos(int nCaracteresConsecutivos) {
		this.nCaracteresConsecutivos = nCaracteresConsecutivos;
	}

	@Override
	public Caracter calcularNumeroCaracteres(String senha) {
		return this.getTipo().getRegra().calcular(this, senha);

	}

}

package com.projeto.model;

public class ContagemCaracteresSequenciais {

	private int nSequencia;
	private int nSequenciaCaracteres;

	public ContagemCaracteresSequenciais(int nSequencia, int nSequenciaCaracteres) {
		this.nSequencia = nSequencia;
		this.nSequenciaCaracteres = nSequenciaCaracteres;
	}

	public int getnSequencia() {
		return nSequencia;
	}

	public void setnSequencia(int nSequencia) {
		this.nSequencia = nSequencia;
	}

	public int getnSequenciaCaracteres() {
		return nSequenciaCaracteres;
	}

	public void setnSequenciaCaracteres(int nSequenciaCaracteres) {
		this.nSequenciaCaracteres = nSequenciaCaracteres;
	}

}

package com.projeto.model;

public class ContagemCaracteresRepetidos {

	private double nRepeticoesIncremento;
	private double nRepeticoesCaracter;

	public ContagemCaracteresRepetidos(double nRepeticoesIncremento, double nRepeticoesCaracter) {
		this.nRepeticoesIncremento = nRepeticoesIncremento;
		this.nRepeticoesCaracter = nRepeticoesCaracter;
	}

	public double getnRepeticoesIncremento() {
		return nRepeticoesIncremento;
	}

	public void setnRepeticoesIncremento(double nRepeticoesIncremento) {
		this.nRepeticoesIncremento = nRepeticoesIncremento;
	}

	public double getnRepeticoesCaracter() {
		return nRepeticoesCaracter;
	}

	public void setnRepeticoesCaracter(double nRepeticoesCaracter) {
		this.nRepeticoesCaracter = nRepeticoesCaracter;
	}

}

package com.projeto.model.tipos;

public enum PesoPorQuantidadeCaracter {

	NUMEROS(4), NUMEROS_MEDIOS(2), NUMEROS_CONSECUTIVOS(2), SIMBOLOS(6), TAMANHO(4),
	MAIUSCULAS_CONSECUTIVAS(2), MINUSCULAS_CONSECUTIVAS(2), NUMERAL_CONSECUTIVO(2),
	SEQUENCIA_LETRAS(3), SEQUENCIA_NUMERAL(3), SEQUENCIA_SIMBOLOS(3), TAMANHO_MINIMO(8);

	private int peso;

	private PesoPorQuantidadeCaracter(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}

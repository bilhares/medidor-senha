package com.projeto.model.tipos;

public enum ValoresParaSequenciais {
	SEQUENCIAL_ALFABETICO("abcdefghijklmnopqrstuvwxyz"), SEQUENCIAL_NUMERICO("01234567890"), SEQUENCIAL_SIMBOLO(")!@#$%^&*(s");

	private String valor;

	private ValoresParaSequenciais(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}

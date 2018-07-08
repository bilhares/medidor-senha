package com.projeto.model.tipos;

public enum ComplexidadeSenha {
	
	MUITO_CURTA("Muito Curta"), MUITO_FRACA("Muito Fraca"), FRACA("Fraca"), BOA("Boa"), FORTE("Forte"), MUITO_FORTE("Muito Forte");
	
	
	private String nome;

	ComplexidadeSenha(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}

package com.projeto.validacoes;

import com.projeto.model.tipos.ComplexidadeSenha;

public class CalculadorComplexidadeSenha {

	public String calcularComplexidade(double score) {
		if (score > 100) {
			score = 100;
		} else if (score < 0) {
			score = 0;
		}
		if (score >= 0 && score < 20)
			return ComplexidadeSenha.MUITO_FRACA.getNome();
		else if (score >= 20 && score < 40)
			return ComplexidadeSenha.FRACA.getNome();
		else if (score >= 40 && score < 60)
			return ComplexidadeSenha.BOA.getNome();
		else if (score >= 60 && score < 80)
			return ComplexidadeSenha.FORTE.getNome();
		else if (score >= 80 && score <= 100)
			return ComplexidadeSenha.MUITO_FORTE.getNome();

		return ComplexidadeSenha.MUITO_CURTA.getNome();
	}
}

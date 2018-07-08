package com.projeto.validacoes;

import java.math.BigDecimal;
import java.math.MathContext;

import com.projeto.model.ContagemCaracteresRepetidos;

public class VerificadorDeRepeticao {

	public ContagemCaracteresRepetidos verificarRepeticao(String senha) {

		double nRepeticoesIncremento = 0;
		double nRepeticoesCaracter = 0;
		double nCaracteresUnicos = 0;

		for (int i = 0; i < senha.length(); i++) {

			boolean temCaracterRepetido = false;

			for (int j = 0; j < senha.length(); j++) {
				//verificacao de cada caracter da senha para saber quais se repetem
				Character ci = senha.charAt(i);
				Character cj = senha.charAt(j);

				BigDecimal a = new BigDecimal(senha.length());
				BigDecimal b = new BigDecimal(j - i);

				if (ci == cj && i != j) {
					//se o caracter existe em diferentes posicoes ocorre a divisao 
					//do tamanho da senha pela diferenca da posicao dos elementos
					//se estao muito juntos valor menor, se estao separados valor maior
					temCaracterRepetido = true;
					BigDecimal result = a.divide(b, MathContext.DECIMAL128);
					nRepeticoesIncremento += Math.abs(result.doubleValue());
				}

			}
			if (temCaracterRepetido) {
				nRepeticoesCaracter++;
				nCaracteresUnicos = senha.length() - nRepeticoesCaracter;
				nRepeticoesIncremento = (int) ((nCaracteresUnicos > 0)
						? Math.ceil(nRepeticoesIncremento / nCaracteresUnicos)
						: Math.ceil(nRepeticoesIncremento));
			}
		}

		return new ContagemCaracteresRepetidos(nRepeticoesIncremento, nRepeticoesCaracter);
	}
}

package com.projeto.validacoes;

import com.projeto.model.CaracterMaiusculos;
import com.projeto.model.CaracterMinusculo;
import com.projeto.model.CaracterNumericos;
import com.projeto.model.CaracterSimbolos;
import com.projeto.model.tipos.PesoPorQuantidadeCaracter;

public class ValidadorRequisitos {
	public double validarRequisitos(CaracterMaiusculos maiusculos, CaracterMinusculo minusculos,
			CaracterNumericos numericos, CaracterSimbolos simbolos, int senha, double scoreAtual) {

		double score = scoreAtual;
		int tamanhoSenha = senha;
		int nCaracteresMaiusculos = maiusculos.getnCaracteres();
		int nCaracteresMinusculos = minusculos.getnCaracteres();
		int nCaracteresNumerais = numericos.getnCaracteres();
		int nSimbolos = simbolos.getnCaracteres();
		int nMinimoReqChar = 0;
		// cira um array com os requisitos minimos para uma senha segura
		int[] totalCaracteres = { tamanhoSenha, nCaracteresMaiusculos, nCaracteresMinusculos, nCaracteresNumerais,
				nSimbolos };
		String[] totalCaracteresId = { "tamanhoPass", "nCaracteresUC", "nCaracteresLC", "nNumber", "nSymbol" };
		int valorMinimo = 0;
		int nReqChar = 0;
		// para cada item desse array é comparado o tipo de validacao
		for (int c = 0; c < totalCaracteres.length; c++) {
			if (totalCaracteresId[c] == "tamanhoPass") {
				valorMinimo = (PesoPorQuantidadeCaracter.TAMANHO_MINIMO.getPeso() - 1);
			} else {
				valorMinimo = 0;
			}

			if (totalCaracteres[c] == (valorMinimo + 1)) {
				nReqChar++;

			} else if (totalCaracteres[c] > (valorMinimo + 1)) {
				nReqChar++;
			}

		}

		if (tamanhoSenha >= PesoPorQuantidadeCaracter.TAMANHO_MINIMO.getPeso()) {
			nMinimoReqChar = 3;
		} else {
			nMinimoReqChar = 4;
		}
		// se os valores dos caracteres forem maiores que os de requisito minimos da
		// senha, eh acrescentado a pontuacao
		if (nReqChar > nMinimoReqChar) {
			score = (score + (nReqChar * 2));
		}

		return score;
	}
}

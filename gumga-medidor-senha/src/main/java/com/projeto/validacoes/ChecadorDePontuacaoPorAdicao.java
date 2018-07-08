package com.projeto.validacoes;

import com.projeto.model.CaracterMaiusculos;
import com.projeto.model.CaracterMinusculo;
import com.projeto.model.CaracterNumericos;
import com.projeto.model.CaracterSimbolos;
import com.projeto.model.tipos.PesoPorQuantidadeCaracter;

public class ChecadorDePontuacaoPorAdicao {

	public double checarPontuacao(CaracterMaiusculos maiusculos, CaracterMinusculo minusculos,
			CaracterNumericos numericos, CaracterSimbolos simbolos, int senha, double scoreAtual) {
		
		double score = scoreAtual;
		int nCaracteresMaiusculos = maiusculos.getnCaracteres();
		int nCaracteresMinusculos = minusculos.getnCaracteres();
		int nCaracteresNumerais = numericos.getnCaracteres();
		int nCaracteresSimbolos = simbolos.getnCaracteres();
		int nMedios =  numericos.getnCaracterMedio() +simbolos.getnCaracterMedio() ;;
		int tamanhoSenha = senha;

		if (nCaracteresMaiusculos > 0 && nCaracteresMaiusculos < tamanhoSenha) {
			score = (score + ((tamanhoSenha - nCaracteresMaiusculos) * 2));
		}
		if (nCaracteresMinusculos > 0 && nCaracteresMinusculos < tamanhoSenha) {
			score = (score + ((tamanhoSenha - nCaracteresMinusculos) * 2));
		}
		if (nCaracteresNumerais > 0 && nCaracteresNumerais < tamanhoSenha) {
			score = (score + (nCaracteresNumerais * PesoPorQuantidadeCaracter.NUMEROS.getPeso()));
		}
		if (nCaracteresSimbolos > 0) {
			score = (score + (nCaracteresSimbolos * PesoPorQuantidadeCaracter.SIMBOLOS.getPeso()));
		}
		if (nMedios > 0) {
			score = (score + (nMedios * PesoPorQuantidadeCaracter.NUMEROS_MEDIOS.getPeso()));
		}
		
		return score;
	}
}

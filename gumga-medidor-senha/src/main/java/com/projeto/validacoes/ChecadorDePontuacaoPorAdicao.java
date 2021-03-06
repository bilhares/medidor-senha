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
		//contagem de pontos para letras maiusculas
		if (nCaracteresMaiusculos > 0 && nCaracteresMaiusculos < tamanhoSenha) {
			score = (score + ((tamanhoSenha - nCaracteresMaiusculos) * 2));
		}
		//contagem de pontos para letras minusculas
		if (nCaracteresMinusculos > 0 && nCaracteresMinusculos < tamanhoSenha) {
			score = (score + ((tamanhoSenha - nCaracteresMinusculos) * 2));
		}
		//contagem de pontos para numeros
		if (nCaracteresNumerais > 0 && nCaracteresNumerais < tamanhoSenha) {
			score = (score + (nCaracteresNumerais * PesoPorQuantidadeCaracter.NUMEROS.getPeso()));
		}
		//contagem de pontos para simbolos
		if (nCaracteresSimbolos > 0) {
			score = (score + (nCaracteresSimbolos * PesoPorQuantidadeCaracter.SIMBOLOS.getPeso()));
		}
		//contagem de pontos para numeros medios acima de 3 caracteres
		if (nMedios > 0) {
			score = (score + (nMedios * PesoPorQuantidadeCaracter.NUMEROS_MEDIOS.getPeso()));
		}
		
		return score;
	}
}

package com.projeto.validacoes;

import com.projeto.model.CaracterMaiusculos;
import com.projeto.model.CaracterMinusculo;
import com.projeto.model.CaracterNumericos;
import com.projeto.model.CaracterSimbolos;
import com.projeto.model.ContagemCaracteresRepetidos;
import com.projeto.model.ContagemCaracteresSequenciais;
import com.projeto.model.tipos.PesoPorQuantidadeCaracter;

public class ChecadorDePontuacaoPorDeducao {

	public double checarPontuacao(CaracterMaiusculos maiusculos, CaracterMinusculo minusculos, CaracterNumericos numericos,
			CaracterSimbolos simbolos, int senha, ContagemCaracteresRepetidos caracteresRepetidos,
			ContagemCaracteresSequenciais sequenciaLetras, ContagemCaracteresSequenciais seqNum,
			ContagemCaracteresSequenciais sequenciaSimbolos, double scoreAtual) {

		double score = scoreAtual;
		int nCaracteresMaiusculos = maiusculos.getnCaracteres();
		int nCaracteresMinusculos = minusculos.getnCaracteres();
		int nCaracteresNumerais = numericos.getnCaracteres();
		int nCaracteresSimbolos = simbolos.getnCaracteres();
		int tamanhoSenha = senha;

		double nCaracterRepetidos = caracteresRepetidos.getnRepeticoesCaracter();
		double nCaracterRepetidosIncremento = caracteresRepetidos.getnRepeticoesIncremento();

		int nCaracteresConsecMaiusculo = maiusculos.getnCaracteresConsecutivos();
		int nCaracteresConsecMinusculo = minusculos.getnCaracteresConsecutivos();
		int nCaracteresConsecNumeral = numericos.getnCaracteresConsecutivos();

		int seqNumerais = seqNum.getnSequencia();
		int seqLetras = sequenciaLetras.getnSequencia();
		int seqSimbolos = sequenciaSimbolos.getnSequencia();

		//somente letras
		if ((nCaracteresMaiusculos > 0 || nCaracteresMinusculos > 0) && nCaracteresSimbolos == 0
				&& nCaracteresNumerais == 0) {
			score = (score - tamanhoSenha);
		}
		//somente numeros
		if (nCaracteresMaiusculos == 0 && nCaracteresMinusculos == 0 && nCaracteresSimbolos == 0
				&& nCaracteresNumerais > 0) {
			score = (score - tamanhoSenha);
		}
		//repeticao de mesmos caracteres
		if (nCaracterRepetidos > 0) {
			score = (int) (score - nCaracterRepetidosIncremento);
		}
		//repeticao consecutiva de caracteres maiusculos
		if (nCaracteresConsecMaiusculo > 0) {
			score = (score
					- (nCaracteresConsecMaiusculo * PesoPorQuantidadeCaracter.MAIUSCULAS_CONSECUTIVAS.getPeso()));
		}
		//repeticao consecutiva de caracteres minusculo 
		if (nCaracteresConsecMinusculo > 0) {
			score = (score
					- (nCaracteresConsecMinusculo * PesoPorQuantidadeCaracter.MINUSCULAS_CONSECUTIVAS.getPeso()));
		}
		//numeros em ordem
		if (nCaracteresConsecNumeral > 0) {
			score = (score - (nCaracteresConsecNumeral * PesoPorQuantidadeCaracter.NUMERAL_CONSECUTIVO.getPeso()));
		}
		//sequencia de letras existentes 
		if (seqLetras > 0) {
			score = (score - (seqLetras * PesoPorQuantidadeCaracter.SEQUENCIA_LETRAS.getPeso()));
		}
		//sequencia de numeros
		if (seqNumerais > 0) {
			score = (score - (seqNumerais * PesoPorQuantidadeCaracter.SEQUENCIA_NUMERAL.getPeso()));
		}
		//sequencia de simbolos
		if (seqSimbolos > 0) {
			score = (score - (seqSimbolos * PesoPorQuantidadeCaracter.SEQUENCIA_SIMBOLOS.getPeso()));
		}

		return score;
	}
}

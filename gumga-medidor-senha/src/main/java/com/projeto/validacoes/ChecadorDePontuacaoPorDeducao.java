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
		int nCaracteresConsecMinusculo = minusculos.getnCaracteresConsecutivos();//era pra te mais
		int nCaracteresConsecNumeral = numericos.getnCaracteresConsecutivos();

		int seqNumerais = seqNum.getnSequencia();
		int seqLetras = sequenciaLetras.getnSequencia();
		int seqSimbolos = sequenciaSimbolos.getnSequencia();

		if ((nCaracteresMaiusculos > 0 || nCaracteresMinusculos > 0) && nCaracteresSimbolos == 0
				&& nCaracteresNumerais == 0) {
			score = (score - tamanhoSenha);
		}
		if (nCaracteresMaiusculos == 0 && nCaracteresMinusculos == 0 && nCaracteresSimbolos == 0
				&& nCaracteresNumerais > 0) {
			score = (score - tamanhoSenha);
		}
		if (nCaracterRepetidos > 0) {
			score = (int) (score - nCaracterRepetidosIncremento);
		}

		if (nCaracteresConsecMaiusculo > 0) {
			score = (score
					- (nCaracteresConsecMaiusculo * PesoPorQuantidadeCaracter.MAIUSCULAS_CONSECUTIVAS.getPeso()));
		}
		if (nCaracteresConsecMinusculo > 0) {//tem a mais
			score = (score
					- (nCaracteresConsecMinusculo * PesoPorQuantidadeCaracter.MINUSCULAS_CONSECUTIVAS.getPeso()));
		}

		if (nCaracteresConsecNumeral > 0) {
			score = (score - (nCaracteresConsecNumeral * PesoPorQuantidadeCaracter.NUMERAL_CONSECUTIVO.getPeso()));
		}

		if (seqLetras > 0) {
			score = (score - (seqLetras * PesoPorQuantidadeCaracter.SEQUENCIA_LETRAS.getPeso()));
		}

		if (seqNumerais > 0) {
			score = (score - (seqNumerais * PesoPorQuantidadeCaracter.SEQUENCIA_NUMERAL.getPeso()));
		}
		if (seqSimbolos > 0) {
			score = (score - (seqSimbolos * PesoPorQuantidadeCaracter.SEQUENCIA_SIMBOLOS.getPeso()));
		}

		return score;
	}
}

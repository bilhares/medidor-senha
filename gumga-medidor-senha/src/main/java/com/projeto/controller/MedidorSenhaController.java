package com.projeto.controller;

import org.springframework.stereotype.Controller;

import com.projeto.model.CaracterMaiusculos;
import com.projeto.model.CaracterMinusculo;
import com.projeto.model.CaracterNumericos;
import com.projeto.model.CaracterSimbolos;
import com.projeto.model.ContagemCaracteresRepetidos;
import com.projeto.model.ContagemCaracteresSequenciais;
import com.projeto.model.Pontuacao;
import com.projeto.model.tipos.PesoPorQuantidadeCaracter;
import com.projeto.model.tipos.ValoresParaSequenciais;
import com.projeto.validacoes.CalculadorComplexidadeSenha;
import com.projeto.validacoes.ChecadorDePontuacaoPorAdicao;
import com.projeto.validacoes.ChecadorDePontuacaoPorDeducao;
import com.projeto.validacoes.ContadorCaracteresSequenciais;
import com.projeto.validacoes.ValidadorRequisitos;
import com.projeto.validacoes.VerificadorDeRepeticao;

@Controller
public class MedidorSenhaController {

	public Pontuacao medirSenha(String senha) {

		int tamanhoSenha = senha.length();

		// Inicialmente o score comeca valendo o tamanho da senha multiplicado por 4
		double scoreAtual = tamanhoSenha * PesoPorQuantidadeCaracter.TAMANHO.getPeso();

		// calcula o numero de caracteres maiusculos, minusculos, numericos e simbolos
		// presentes na senha
		CaracterMaiusculos maiusculos = (CaracterMaiusculos) new CaracterMaiusculos().calcularNumeroCaracteres(senha);
		CaracterMinusculo minusculos = (CaracterMinusculo) new CaracterMinusculo().calcularNumeroCaracteres(senha);
		CaracterNumericos numericos = (CaracterNumericos) new CaracterNumericos().calcularNumeroCaracteres(senha);
		CaracterSimbolos simbolos = (CaracterSimbolos) new CaracterSimbolos().calcularNumeroCaracteres(senha);

		// conta os caracteres repetidos na senha
		ContagemCaracteresRepetidos caracteresRepetidos = new VerificadorDeRepeticao().verificarRepeticao(senha);

		// conta os caracteres em sequencia na senha ex: abc, 123...
		ContagemCaracteresSequenciais seqLetras = new ContadorCaracteresSequenciais().contarSequencias(23,
				ValoresParaSequenciais.SEQUENCIAL_ALFABETICO.getValor(), senha);
		ContagemCaracteresSequenciais seqNum = new ContadorCaracteresSequenciais().contarSequencias(8,
				ValoresParaSequenciais.SEQUENCIAL_NUMERICO.getValor(), senha);
		ContagemCaracteresSequenciais seqSimbolos = new ContadorCaracteresSequenciais().contarSequencias(8,
				ValoresParaSequenciais.SEQUENCIAL_SIMBOLO.getValor(), senha);

		// a partir do numero de caracteres por tipo é calculado o score por adição,
		// onde cada tipo tem seu peso
		scoreAtual = new ChecadorDePontuacaoPorAdicao().checarPontuacao(maiusculos, minusculos, numericos, simbolos,
				tamanhoSenha, scoreAtual);

		// a partir das repeticoes, caracteres em sequencia é calculado a pontuação por
		// dedução no qual se tira os pontos
		scoreAtual = new ChecadorDePontuacaoPorDeducao().checarPontuacao(maiusculos, minusculos, numericos, simbolos,
				tamanhoSenha, caracteresRepetidos, seqLetras, seqNum, seqSimbolos, scoreAtual);

		// valida os requisitos esperados em uma senha
		scoreAtual = new ValidadorRequisitos().validarRequisitos(maiusculos, minusculos, numericos, simbolos,
				tamanhoSenha, scoreAtual);

		// calcula a complexidade da senha com base no score
		String complexidadeSenha = new CalculadorComplexidadeSenha().calcularComplexidade(scoreAtual);

		System.out.println("SCORE: " + scoreAtual + "%\nComplexidade:" + complexidadeSenha);

		return new Pontuacao(scoreAtual, complexidadeSenha);
	}

}

package com.projeto.validacoes;

import com.projeto.model.ContagemCaracteresSequenciais;

public class ContadorCaracteresSequenciais {

	public ContagemCaracteresSequenciais contarSequencias(int tamanhoContagem, String valores, String senha) {
		int nSequencia = 0;
		int nSequenciaCaracteres = 0;
		// pega de 3 em 3 digitos de uma sequencia de letras, numeros, ou simbolos e
		// compara com a senha...
		// Se existir na senha caracteres em ordem sequencial ex: 123, abc o valor da
		// variavel que salva quantidade com que isso ocorre é incrementado...
		// para cada tipo de caracter de sequencia existe uma contagem de loop, pois as
		// sequencias nao possuem o mesmo tamanho e a conta é diferente
		for (int s = 0; s < tamanhoContagem; s++) {

			String seqFront = valores.substring(s, (s + 3));
			String seqRever = new StringBuilder(seqFront).reverse().toString();

			int seqOrdemAlf = senha.toLowerCase().indexOf(seqFront);
			int seqOrdemAlfRever = senha.toLowerCase().indexOf(seqRever);

			if (seqOrdemAlf != -1 || seqOrdemAlfRever != -1) {
				nSequencia++;
				nSequenciaCaracteres++;
			}
		}

		return new ContagemCaracteresSequenciais(nSequencia, nSequenciaCaracteres);
	}

}

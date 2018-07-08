package com.projeto.validacoes;

import com.projeto.model.ContagemCaracteresSequenciais;

public class ContadorCaracteresSequenciais {

	public ContagemCaracteresSequenciais contarSequencias(int tamanhoContagem, String valores, String senha) {
		int nSequencia = 0;
		int nSequenciaCaracteres = 0;

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

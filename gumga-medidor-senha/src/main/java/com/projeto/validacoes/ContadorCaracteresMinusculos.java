package com.projeto.validacoes;

import com.projeto.model.Caracter;
import com.projeto.model.CaracterMinusculo;
import com.projeto.model.tipos.PatternRegex;
import com.projeto.regras.RegraCalculoCaracteres;

public class ContadorCaracteresMinusculos implements RegraCalculoCaracteres {

	public Caracter calcular(Caracter c, String senha) {

		String nTempContadorCarac = "";
		int nCaracteres = 0;
		int nCaracterConsecutivo = 0;

		for (int i = 0; i < senha.length(); i++) {
			Character caracter = senha.charAt(i);
			if (caracter.toString().matches(PatternRegex.MINUSCLULO.getPattern())) {
				if (nTempContadorCarac != "") {
					if ((Integer.parseInt(nTempContadorCarac) + 1) == i) {
						nCaracterConsecutivo++;
					}
				}
				nTempContadorCarac = String.valueOf(i);
				nCaracteres++;
			}
		}
		CaracterMinusculo retorno = new CaracterMinusculo();
		retorno.setnCaracteres(nCaracteres);
		retorno.setnCaracteresConsecutivos(nCaracterConsecutivo);

		return retorno;
	}
}

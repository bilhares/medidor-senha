package com.projeto.validacoes;

import com.projeto.model.Caracter;
import com.projeto.model.CaracterMaiusculos;
import com.projeto.model.tipos.PatternRegex;
import com.projeto.regras.RegraCalculoCaracteres;

public class ContadorCaracteresMaiusculos implements RegraCalculoCaracteres {
	public Caracter calcular(Caracter c, String senha) {

		String nTempContadorCarac = "";
		int nCaracteres = 0;
		int nCaracterConsecutivo = 0;

		for (int i = 0; i < senha.length(); i++) {
			Character caracter = senha.charAt(i);
			if (caracter.toString().matches(PatternRegex.MAIUSCULO.getPattern())) {
				if (nTempContadorCarac != "") {
					if ((Integer.parseInt(nTempContadorCarac )+ 1) == i) {
						nCaracterConsecutivo++;
					}
				}
				nTempContadorCarac = String.valueOf(i);
				nCaracteres++;
			}
		}
		CaracterMaiusculos retorno = new CaracterMaiusculos();
		retorno.setnCaracteres(nCaracteres);
		retorno.setnCaracteresConsecutivos(nCaracterConsecutivo);

		return retorno;
	}
}

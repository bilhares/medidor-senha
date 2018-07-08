package com.projeto.validacoes;

import com.projeto.model.Caracter;
import com.projeto.model.CaracterNumericos;
import com.projeto.model.tipos.PatternRegex;
import com.projeto.regras.RegraCalculoCaracteres;

public class ContadorCaracteresNumerico implements RegraCalculoCaracteres {

	@Override
	public Caracter calcular(Caracter c, String senha) {
		String nTempContadorCarac = "";
		int nCaracteres = 0;
		int nCaracterConsecutivo = 0;
		int nCaracterMedio = 0;

		for (int i = 0; i < senha.length(); i++) {
			Character caracter = senha.charAt(i);
			if (caracter.toString().matches(PatternRegex.NUMERICO.getPattern())) {
				if (i > 0 && i < (senha.length() - 1)) {
					nCaracterMedio++;
				}
				if (nTempContadorCarac != ""){
					if ((Integer.parseInt(nTempContadorCarac) + 1) == i) {
						nCaracterConsecutivo++;
					}
				}
				nTempContadorCarac = String.valueOf(i);
				nCaracteres++;
			}
		}

		CaracterNumericos retorno = new CaracterNumericos();

		retorno.setnCaracteres(nCaracteres);
		retorno.setnCaracteresConsecutivos(nCaracterConsecutivo);
		retorno.setnCaracterMedio(nCaracterMedio);

		return retorno;
	}

}

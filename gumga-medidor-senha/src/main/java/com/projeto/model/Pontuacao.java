package com.projeto.model;

public class Pontuacao {

	private double score;
	private String complexidade;

	public Pontuacao(double score, String complexidade) {
		if (score > 100) {
			this.score = 100;
		} else if (score < 0) {
			this.score = 0;
		} else {
			this.score = score;
		}
		this.complexidade = complexidade;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getComplexidade() {
		return complexidade;
	}

	public void setComplexidade(String complexidade) {
		this.complexidade = complexidade;
	}

}

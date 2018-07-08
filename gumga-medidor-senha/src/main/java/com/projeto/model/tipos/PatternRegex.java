package com.projeto.model.tipos;

public enum PatternRegex {

	MAIUSCULO("[A-Z]"), NUMERICO("[0-9]"), MINUSCLULO("[a-z]"), SIMBOLOS("[^a-zA-Z0-9_]");

	private String pattern;

	private PatternRegex(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}

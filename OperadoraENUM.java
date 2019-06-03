package br.edu.unifacisa.bd;

public enum OperadoraENUM {
	OI("OI"), CLARO("CLARO"), VIVO("VIVO");
	private String operadora;

	OperadoraENUM(String tipo) {
		this.operadora = tipo;

	}

	public String obterOperadora() {
		return this.operadora;
	}

}

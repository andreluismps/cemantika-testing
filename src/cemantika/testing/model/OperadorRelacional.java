package cemantika.testing.model;

public enum OperadorRelacional {
	MAIOR(">"), MENOR("<"), MAIOR_IGUAL(">="), MENOR_IGUAL("<="), DIFERENTE("!="), IGUAL("==");
	
private final String operadorRelacional;
	
	private OperadorRelacional(String operador) {
		operadorRelacional = operador;
	}
	
	public String getOperadorRelacional(){
		return operadorRelacional;
	}
	
}

package cemantika.testing.model;



public class Dominio {
	
	private TipoElementoContextual tipoEC;
	private OperadorRelacional operador;
	private String valor;
	private String original;
	
	public Dominio(String valorOriginal){
		this.original = valorOriginal;
		//parse das regras de negocio
		
		String [] chaves = valorOriginal.split("\\.");
		
		for (TipoElementoContextual tipoEC : TipoElementoContextual.values()) {
			if (chaves[0].equals(tipoEC.getFonteContexto())){
				this.tipoEC = tipoEC;
				break;
			}
		}
		
		String [] chaves2 = chaves[1].split(" ");
		
		for (OperadorRelacional operador : OperadorRelacional.values()) {
			if (chaves2[1].equals(operador.getOperadorRelacional())){
				this.operador = operador;
				break;
			}
		}
		
		valor = chaves2[2];
	}
	
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public TipoElementoContextual getTipoEC() {
		return tipoEC;
	}
	public void setTipoEC(TipoElementoContextual tipoEC) {
		this.tipoEC = tipoEC;
	}
	public OperadorRelacional getOperador() {
		return operador;
	}
	public void setOperador(OperadorRelacional operador) {
		this.operador = operador;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
}

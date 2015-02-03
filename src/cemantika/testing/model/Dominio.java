package cemantika.testing.model;


public class Dominio {
	private String original;
	private TipoElementoContextual tipoEC;
	private OperadorRelacional operador;
	private String valor;
	
	public Dominio(String valorOriginal){
		this.original = valorOriginal;
		//parse das regras de negocio
		String [] chaves = valorOriginal.split(".");
		if (chaves.equals(TipoElementoContextual.LUMINOSIDADE.getFonteContexto())){
			tipoEC = TipoElementoContextual.LUMINOSIDADE;
		}
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

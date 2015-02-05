package cemantika.testing.model;

import java.util.ArrayList;
import java.util.List;



public class Dominio {
	
	private TipoElementoContextual tipoEC;
	private List<String> limites;
	private List<OperadorRelacional> operadores;
	private String original;
	
	public Dominio(String valorOriginal){
		valorOriginal = valorOriginal.replace(';', '\0');
		this.original = valorOriginal;
		//parse das regras de negocio
		
		String [] values = valorOriginal.split("&&");
		limites = new ArrayList<String>();
		operadores = new ArrayList<OperadorRelacional>();
		for (String value : values) {
			
			String [] chaves = value.split("\\.");
			
			for (TipoElementoContextual tipoEC : TipoElementoContextual.values()) {
				if (chaves[0].equals(tipoEC.getFonteContexto())){
					this.tipoEC = tipoEC;
					break;
				}
			}
			
			
			
			String [] chaves2 = chaves[1].split(" ");
			
			
			for (OperadorRelacional operadorRelacional : OperadorRelacional.values()) {
				if (chaves2[1].equals(operadorRelacional.getOperadorRelacional())){
					operadores.add(operadorRelacional);
					break;
				}
			}
			
			limites.add(chaves2[2].trim());
			
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

	public List<String> getLimites() {
		return limites;
	}

	public void setLimites(List<String> limites) {
		this.limites = limites;
	}

	public List<OperadorRelacional> getOperadores() {
		return operadores;
	}

	public void setOperadores(List<OperadorRelacional> operadores) {
		this.operadores = operadores;
	}
}

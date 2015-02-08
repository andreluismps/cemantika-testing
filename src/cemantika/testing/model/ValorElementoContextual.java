package cemantika.testing.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ValorElementoContextual {
	
	private TipoElementoContextual tipoEC;
	
	private int valor;
	
	private String descricao;
	
	@XmlAttribute
	public TipoElementoContextual getTipoEC() {
		return tipoEC;
	}
	public void setTipoEC(TipoElementoContextual tipoEC) {
		this.tipoEC = tipoEC;
	}
	@XmlAttribute
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@XmlAttribute
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return this.tipoEC.getFonteContexto() + ": " + this.getValor();
	}
	
	
}

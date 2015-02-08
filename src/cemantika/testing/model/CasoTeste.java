package cemantika.testing.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="casoTeste")
public class CasoTeste {
	
	
	private List<ValorElementoContextual> valores;
	
	public CasoTeste(){
		valores = new ArrayList<ValorElementoContextual>();
	}

	@XmlElement(name="valorEC")
	public List<ValorElementoContextual> getValores() {
		return valores;
	}

	public void setValores(List<ValorElementoContextual> valores) {
		this.valores = valores;
	}
	
	
}

package cemantika.testing.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="suite")
public class SuiteTeste {
	List<CasoTeste> casosTeste;

	@XmlElement(name="casoTeste")
	public List<CasoTeste> getCasosTeste() {
		return casosTeste;
	}

	public void setCasosTeste(List<CasoTeste> casosTeste) {
		this.casosTeste = casosTeste;
	}
}

package cemantika.testing.model;

import java.util.ArrayList;
import java.util.List;

public class CasoTeste {
	
	private List<ValorElementoContextual> valores;
	
	public CasoTeste(){
		valores = new ArrayList<ValorElementoContextual>();
	}

	public List<ValorElementoContextual> getValores() {
		return valores;
	}

	public void setValores(List<ValorElementoContextual> valores) {
		this.valores = valores;
	}
	
	
}

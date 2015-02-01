package cemantika.testing.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import cemantika.testing.model.CasoTeste;
import cemantika.testing.model.Dominio;

public class Engine {
	File gerarCasoTeste(File gc) throws FileNotFoundException, JAXBException, XMLStreamException {
		List<Dominio> dominiosEC = new LeitorGrafo().lerGrafo(gc);
		
		List<CasoTeste> casosTeste = new GeradorCasoTeste().gerarCasosTeste(dominiosEC);
		
		casosTeste = new RedutorCasoTeste().reduzirCasosTeste(casosTeste);
		
		File xmlSimulador = new GeradorXMLSimulador().gerarSequenciaTemporal(casosTeste);
		
		return xmlSimulador;
	}

}

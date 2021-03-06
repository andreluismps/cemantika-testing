package cemantika.testing.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import cemantika.testing.model.CasoTeste;
import cemantika.testing.model.Dominio;

public class Engine {
	File gerarCasoTeste(File contextualGraph, File umlClassDiagram) throws FileNotFoundException, JAXBException, XMLStreamException {
		List<List<Dominio>> dominiosEC = new LeitorGrafo().lerGrafo(contextualGraph, umlClassDiagram);
		
		List<CasoTeste> casosTeste = new GeradorCasoTeste().gerarCasosTeste(dominiosEC);
		
		casosTeste = new RedutorCasoTeste().reduzirCasosTeste(casosTeste);
		
		File xmlSimulador = new GeradorXMLSimulador().gerarSequenciaTemporal(casosTeste);
		
		return xmlSimulador;
	}

}

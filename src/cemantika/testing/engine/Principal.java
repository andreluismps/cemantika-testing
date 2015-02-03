package cemantika.testing.engine;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class Principal {
	
	
	public static void main(String[] args) throws FileNotFoundException, JAXBException, XMLStreamException{
		new Engine().gerarCasoTeste(new File("src/cemantika/testing/engine/controle_iluminacao_tela.rf"));
		//new Engine().gerarCasoTeste(new File("src/cemantika/testing/engine/ProfessorBookTransport.rf"));
	}
}

package cemantika.testing.engine;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import cemantika.testing.model.CasoTeste;
import cemantika.testing.model.SuiteTeste;

public class GeradorXMLSimulador {

	public File gerarSequenciaTemporal(List<CasoTeste> casosReduzidos) throws JAXBException, XMLStreamException {
		File xmlSimulador = new File("src/cemantika/testing/engine/controle_iluminacao_tela_teste.xml");
		JAXBContext jc = JAXBContext.newInstance(cemantika.testing.model.SuiteTeste.class);		
		Marshaller m = jc.createMarshaller();
		SuiteTeste suite = new SuiteTeste();
		suite.setCasosTeste(casosReduzidos);
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		m.marshal(suite, xmlSimulador);
		
		suite = null;
		
		XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(xmlSimulador);
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        xsr.nextTag();
        while(!xsr.getLocalName().equals("suite")) {
            xsr.nextTag();
        }
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<SuiteTeste> jb = unmarshaller.unmarshal(xsr, SuiteTeste.class);
        suite = jb.getValue();
        

		
		return xmlSimulador;
	}

}

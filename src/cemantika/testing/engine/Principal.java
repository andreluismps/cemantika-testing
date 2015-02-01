package cemantika.testing.engine;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import cemantika.testing.cxg.xsd.ActionNode;
import cemantika.testing.cxg.xsd.Connection;
import cemantika.testing.cxg.xsd.Connections;
import cemantika.testing.cxg.xsd.End;
import cemantika.testing.cxg.xsd.Join;
import cemantika.testing.cxg.xsd.Nodes;
import cemantika.testing.cxg.xsd.Process;
import cemantika.testing.cxg.xsd.Split;
import cemantika.testing.cxg.xsd.Start;

public class Principal {
	
	
	public static void main(String[] args) throws FileNotFoundException, JAXBException, XMLStreamException{
		//File saidaSimulador = new Engine().gerarCasoTeste(new File("src/cemantika/testing/engine/controle_iluminacao_tela.rf"));
		//saidaSimulador.exists();
		
		XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("src/cemantika/testing/engine/controle_iluminacao_tela.rf");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        xsr.nextTag();
        while(!xsr.getLocalName().equals("process")) {
            xsr.nextTag();
        }
 
        JAXBContext jc = JAXBContext.newInstance(cemantika.testing.cxg.xsd.Process.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<cemantika.testing.cxg.xsd.Process> jb = unmarshaller.unmarshal(xsr, cemantika.testing.cxg.xsd.Process.class);
        Process p = jb.getValue();
        System.out.println(p.getId());
        Nodes nos = null;;
        Connections connections = null;
        Start start = null;
        End end = null;
        ActionNode actionNode = null;
        Join join = null;
        Split split = null;
        for (Object nodesOrConnections : p.getHeaderOrNodesOrConnections()) {
			if (nodesOrConnections instanceof Nodes){
				nos = (Nodes) nodesOrConnections;
				for (Object no : nos.getStartOrEndOrActionNode()){
					if (no instanceof Start){
						start = (Start) no;
						System.out.println(start);
					}else if (no instanceof End) {
						end = (End) no;
						System.out.println(end);
					}else if (no instanceof ActionNode) {
						actionNode = (ActionNode) no;
						System.out.println(actionNode);
					}else if (no instanceof Join) {
						join = (Join) no;
						System.out.println(join);
					}else if (no instanceof Split) {
						split = (Split) no;
						System.out.println(split);
					}
				}
			}else if (nodesOrConnections instanceof Connections) {
				connections = (Connections) nodesOrConnections;
			}
		}
        if (connections != null){
        	for (Connection connection : connections.getConnection()) {
				System.out.println(connection.toString());
			}
        }
        xsr.close();
	}
}
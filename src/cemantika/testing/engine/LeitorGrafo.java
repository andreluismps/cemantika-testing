package cemantika.testing.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import cemantika.testing.cxg.Grafo;
import cemantika.testing.cxg.xsd.ActionNode;
import cemantika.testing.cxg.xsd.Connection;
import cemantika.testing.cxg.xsd.Connections;
import cemantika.testing.cxg.xsd.Constraint;
import cemantika.testing.cxg.xsd.Constraints;
import cemantika.testing.cxg.xsd.End;
import cemantika.testing.cxg.xsd.Join;
import cemantika.testing.cxg.xsd.Nodes;
import cemantika.testing.cxg.xsd.Split;
import cemantika.testing.cxg.xsd.Start;
import cemantika.testing.model.Dominio;

public class LeitorGrafo {
	public List<Dominio> lerGrafo(File grafoContextual) throws JAXBException, FileNotFoundException, XMLStreamException{
		
		XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(grafoContextual);
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        xsr.nextTag();
        while(!xsr.getLocalName().equals("process")) {
            xsr.nextTag();
        }
 
        JAXBContext jc = JAXBContext.newInstance(cemantika.testing.cxg.xsd.Process.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<cemantika.testing.cxg.xsd.Process> jb = unmarshaller.unmarshal(xsr, cemantika.testing.cxg.xsd.Process.class);
        cemantika.testing.cxg.xsd.Process p = jb.getValue();

        Nodes nos = null;;
        Connections connections = null;
        Start start = null;
        End end = null;
        ActionNode actionNode = null;
        Join join = null;
        Split split = null;
        List<Split> nosContextuais = new ArrayList<Split>();
        //percorre objetos do xml
        for (Object nodesOrConnections : p.getHeaderOrNodesOrConnections()) {
			if (nodesOrConnections instanceof Nodes){
				nos = (Nodes) nodesOrConnections;
				for (Object no : nos.getStartOrEndOrActionNode()){
					if (no instanceof Start){
						start = (Start) no;
						//System.out.println(start);
					}else if (no instanceof End) {
						end = (End) no;
						//System.out.println(end);
					}else if (no instanceof ActionNode) {
						actionNode = (ActionNode) no;
						//System.out.println(actionNode);
					}else if (no instanceof Join) {
						join = (Join) no;
						//System.out.println(join);
					}else if (no instanceof Split) {
						split = (Split) no;
						nosContextuais.add(split);
						//System.out.println(split);
					}
				}
			}else if (nodesOrConnections instanceof Connections) {
				connections = (Connections) nodesOrConnections;
			}
		}
        
        //popula grafo
        Grafo grafo = new Grafo();
        if (connections != null){
        	for (Connection connection : connections.getConnection()) {
        		grafo.adicionaAresta(connection.getFrom(), connection.getTo());
			}
        }
        
        //encontra camnhos
        List<ArrayList<String>> caminhos = grafo.listarCaminhos(grafo, start.getId(), end.getId());
        
        
        //percorre caminhos
        int i = 0;
        int pos = 0;
        int ctCount = 0;
        Constraints constraints;
        for(ArrayList<String> path : caminhos){
        	i = 0;
        	ctCount++;
        	System.out.println("\nCT" + ctCount + ":");
	        for (String node : path) {
	            //System.out.print(node);
	           // System.out.print(" - ");
	            if (pos != 0){
	            	System.out.print("no contextual: " + path.get(pos));
	            	System.out.println(";   no proximo: " + node);
	            	for (Split noContextual : nosContextuais) {
	            		if (noContextual.getId().equals(path.get(pos))){
	            			for (Object o : noContextual.getMetaDataOrConstraints()) {
	            				if(o instanceof Constraints){
	            					constraints = (Constraints) o;
	            					for (Constraint constraint : constraints.getConstraint()) {
	            						if(constraint.getToNodeId().equals(node)){
											System.out.println(constraint.getValue());
										}
									}
								}
							}
	            		}
	            	}
	            	pos = 0;
	            }
	            for (Split noContextual : nosContextuais) {
					if (noContextual.getId().equals(node)){
						pos = i;
						break;
					}
				}
	            i++;
	        }
	        System.out.println();
	    }
        xsr.close();

		
		return null;
	}
}

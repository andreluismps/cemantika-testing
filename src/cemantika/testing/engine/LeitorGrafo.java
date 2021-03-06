package cemantika.testing.engine;

import java.beans.Introspector;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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

import org.cemantika.metamodel.structure.AcquisitionAssociation;
import org.cemantika.metamodel.structure.ContextSource;
import org.cemantika.metamodel.structure.ContextualElement;
import org.cemantika.metamodel.structure.UpdateType;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.process.Node;
import org.drools.io.ResourceFactory;
import org.drools.process.core.Context;
import org.drools.process.core.context.variable.VariableScope;
import org.drools.process.core.impl.ProcessImpl;
import org.drools.ruleflow.core.RuleFlowProcess;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;
import org.drools.workflow.core.impl.ConnectionImpl;

import cemantika.testing.cxg.Grafo;
import cemantika.testing.cxg.xsd.ActionNode;
import cemantika.testing.cxg.xsd.Connection;
import cemantika.testing.cxg.xsd.Connections;
import cemantika.testing.cxg.xsd.Constraint;
import cemantika.testing.cxg.xsd.Constraints;
import cemantika.testing.cxg.xsd.End;
import cemantika.testing.cxg.xsd.Header;
import cemantika.testing.cxg.xsd.Join;
import cemantika.testing.cxg.xsd.Nodes;
import cemantika.testing.cxg.xsd.Split;
import cemantika.testing.cxg.xsd.Start;
import cemantika.testing.cxg.xsd.Type;
import cemantika.testing.cxg.xsd.Variable;
import cemantika.testing.cxg.xsd.Variables;
import cemantika.testing.model.Dominio;

public class LeitorGrafo {
	public List<List<Dominio>> lerGrafo(File contextualGraph, File umlClassDiagram) throws JAXBException, FileNotFoundException, XMLStreamException{
		
		List<List<Dominio>> dominiosGrafo = new ArrayList<List<Dominio>>();
        
		XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(contextualGraph);
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        xsr.nextTag();
        while(!xsr.getLocalName().equals("process")) {
            xsr.nextTag();
        }
 
        JAXBContext jc = JAXBContext.newInstance(cemantika.testing.cxg.xsd.Process.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBElement<cemantika.testing.cxg.xsd.Process> jb = unmarshaller.unmarshal(xsr, cemantika.testing.cxg.xsd.Process.class);
        cemantika.testing.cxg.xsd.Process p = jb.getValue();

        
        Nodes nos = null;
        Header header = null;
        Variables variables = null;
        Type type = null;
        Connections connections = null;
        Start start = null;
        End end = null;
        ActionNode actionNode = null;
        Join join = null;
        Split split = null;
        List<Split> nosContextuais = new ArrayList<Split>();
        
        //percorre objetos do xml
        for (Object nodesOrConnectionsOrHeaders : p.getHeaderOrNodesOrConnections()) {
        	if (nodesOrConnectionsOrHeaders instanceof Header){
        		header = (Header) nodesOrConnectionsOrHeaders;
        		for (Object vars : header.getImportsOrFunctionImportsOrGlobals()) {
					if (vars instanceof Variables){
						variables = (Variables) vars;
						for (Variable variable : variables.getVariable()) {
							for(Object typeOrValue : variable.getTypeOrValue()){
								if (typeOrValue instanceof Type){
									type = (Type) typeOrValue;
									type.getClassName();
								}
							}
						}
					}
				}
        	}
			if (nodesOrConnectionsOrHeaders instanceof Nodes){
				nos = (Nodes) nodesOrConnectionsOrHeaders;
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
			}else if (nodesOrConnectionsOrHeaders instanceof Connections) {
				connections = (Connections) nodesOrConnectionsOrHeaders;
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
        List<Dominio> dominios;
        Dominio dominio;
        for(ArrayList<String> path : caminhos){
        	i = 0;
        	ctCount++;
        	dominios = new ArrayList<Dominio>();
        	//System.out.println("Dominio " + ctCount + ":");
	        for (String node : path) {
	            //System.out.print(node);
	           // System.out.print(" - ");
	            if (pos != 0){
	            	//System.out.print("no contextual: " + path.get(pos));
	            	//System.out.println(";   no proximo: " + node);
	            	for (Split noContextual : nosContextuais) {
	            		if (noContextual.getId().equals(path.get(pos))){
	            			for (Object o : noContextual.getMetaDataOrConstraints()) {
	            				if(o instanceof Constraints){
	            					constraints = (Constraints) o;
	            					for (Constraint constraint : constraints.getConstraint()) {
	            						if(constraint.getToNodeId().equals(node)){
											//System.out.println(constraint.getValue());
											dominio = new Dominio(constraint.getValue());
											dominios.add(dominio);
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
	        dominiosGrafo.add(dominios);
	        //System.out.println();
	    }
        xsr.close();

		
		return dominiosGrafo;
	}
	/*
	 * teste com a api do jboss drools. Nao deu certo pois n�o era poss�vel obter as vari�veis de constraint.
	 * Apos modifica��o no Jboss drools foi poss�vel obter as constraints.
	 * Proximo passo: obter as fontes de contexto dos atributos usados nos n�s contextuais.
	 * Identificado problema grave: como mapear a AcquisitionAssociation no c�digo-fonte??? Talvez seja necess�rio realizar a verifica��o no modelo mesmo. 
	 */
	public static final void main(String[] args) {
        try {
            KnowledgeBase knowledgeBase = readRule();
            StatefulKnowledgeSession ksession = knowledgeBase.newStatefulKnowledgeSession();
                        
            RuleFlowProcess p = (RuleFlowProcess)  ksession.getKnowledgeBase().getProcess("contextual_graph_0");
            //Node node = p.getNode(3);
            for (Node node : p.getNodes()) {
				if (node instanceof org.drools.workflow.core.node.Split){
					org.drools.workflow.core.node.Split split = (org.drools.workflow.core.node.Split) node;
					List<org.drools.definition.process.Connection> conns = split.getOutgoingConnections("DROOLS_DEFAULT");
					for (org.drools.definition.process.Connection conn : conns) {
						org.drools.workflow.core.Constraint constraint = split.getConstraint(conn);
						System.out.println(constraint.getName());
			            System.out.println(constraint.getConstraint());
			            String condition = constraint.getConstraint();
			            condition.toLowerCase();
			            condition = condition.replace("return ", "").replace(".equals", "  ")
			            					 .replace("!", "    ").replace("&&", "  ")
			            					 .replace("||", " ").replace('(', '\0')
			            					 .replace(')', '\0').replace(';', '\0')
			            					 .replace(".get", ".").replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","")
			            					 .trim().replaceAll(" +", " ");
			            List<Context>contexts = p.getContexts("VariableScope");
			            VariableScope varscope = (VariableScope) contexts.get(0);
			            List<org.drools.process.core.context.variable.Variable> vars = varscope.getVariables();
			            
			            String [] statements = condition.split(" ");
			            for (String statement : statements) {
			            	statement = statement.trim();
			            	String [] statmentElements = statement.split("\\.");
			            	String statementVariable = statmentElements[0];
			            	Class clazz = null;
			            	org.drools.process.core.context.variable.Variable variable = null;
			            	for (org.drools.process.core.context.variable.Variable var : vars) {
								if (var.getName().equals(statementVariable)) {
									variable = var;
									clazz = Class.forName(var.getType().getStringType());
								}
							}
			            	
			            	int i = 0;
			            	Field field = null;
			            	List<UpdateType> updateTypes = new ArrayList<UpdateType>();
			            	for (String statmentElement : statmentElements) {
			            		statmentElement = Introspector.decapitalize(statmentElement);
			            		if (i != 0) {
			            			Field[] fields = clazz.getDeclaredFields();
			            			for (Field field2 : fields) {
										if (field2.getName().equals(statmentElement)){
											field = field2;
										}
									}
			            			//field = clazz.getClass().getDeclaredField(statmentElement);
			            			if (field.getAnnotation(ContextualElement.class) != null){
			            				Class contextSourceClazz = field.getType();
		            					if (contextSourceClazz.getAnnotation(ContextSource.class) != null){
		            						Field[] contextSourceFields = contextSourceClazz.getFields();
		            						for (Field contextSourceField : contextSourceFields) {
		            							Annotation[] annotations = contextSourceField.getAnnotations();
		            							for (Annotation annotation : annotations) {
		            								AcquisitionAssociation acquisitionAssociation = null;
													if (annotation instanceof AcquisitionAssociation){
														acquisitionAssociation = (AcquisitionAssociation) annotation;
														if (acquisitionAssociation.element().equalsIgnoreCase(statmentElements[i-1] + "." + statmentElements[i])){
															updateTypes.add(acquisitionAssociation.updateFrequency());
														}
													}
												}
											}
		            					}
			            			}
								}
								i++;
							}
						}
			            
			            System.out.println(condition);
					}
				}
			}
        } catch ( Throwable t ) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readRule() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();        
        kbuilder.add( ResourceFactory.newFileResource(new File( "src/cemantika/testing/engine/contextual_graph_0.rf")), ResourceType.DRF );

        if (kbuilder.hasErrors()){
        	throw new RuntimeException(kbuilder.getErrors().toString());
        }
        
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        
        kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );
        


        return kbase;
    }
}

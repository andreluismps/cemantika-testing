//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.01 at 02:47:35 PM GMT-03:00 
//


package cemantika.testing.cxg.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://drools.org/drools-5.0/process}start"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}end"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}actionNode"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}ruleSet"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}split"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}join"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}milestone"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}subProcess"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}workItem"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}timerNode"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}humanTask"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}composite"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}forEach"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}eventNode"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}fault"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}state"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}dynamic"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "startOrEndOrActionNode"
})
@XmlRootElement(name = "nodes")
public class Nodes {

    @XmlElements({
        @XmlElement(name = "composite", type = Composite.class),
        @XmlElement(name = "subProcess", type = SubProcess.class),
        @XmlElement(name = "workItem", type = WorkItem.class),
        @XmlElement(name = "timerNode", type = TimerNode.class),
        @XmlElement(name = "end", type = End.class),
        @XmlElement(name = "start", type = Start.class),
        @XmlElement(name = "join", type = Join.class),
        @XmlElement(name = "milestone", type = Milestone.class),
        @XmlElement(name = "forEach", type = ForEach.class),
        @XmlElement(name = "dynamic", type = Dynamic.class),
        @XmlElement(name = "actionNode", type = ActionNode.class),
        @XmlElement(name = "split", type = Split.class),
        @XmlElement(name = "fault", type = Fault.class),
        @XmlElement(name = "ruleSet", type = RuleSet.class),
        @XmlElement(name = "humanTask", type = HumanTask.class),
        @XmlElement(name = "state", type = State.class),
        @XmlElement(name = "eventNode", type = EventNode.class)
    })
    protected List<Object> startOrEndOrActionNode;

    /**
     * Gets the value of the startOrEndOrActionNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the startOrEndOrActionNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStartOrEndOrActionNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Composite }
     * {@link SubProcess }
     * {@link WorkItem }
     * {@link TimerNode }
     * {@link End }
     * {@link Start }
     * {@link Join }
     * {@link Milestone }
     * {@link ForEach }
     * {@link Dynamic }
     * {@link ActionNode }
     * {@link Split }
     * {@link Fault }
     * {@link RuleSet }
     * {@link HumanTask }
     * {@link State }
     * {@link EventNode }
     * 
     * 
     */
    public List<Object> getStartOrEndOrActionNode() {
        if (startOrEndOrActionNode == null) {
            startOrEndOrActionNode = new ArrayList<Object>();
        }
        return this.startOrEndOrActionNode;
    }

}

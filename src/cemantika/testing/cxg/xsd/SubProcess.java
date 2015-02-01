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
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{http://drools.org/drools-5.0/process}metaData"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}mapping"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}timers"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}onEntry"/>
 *         &lt;element ref="{http://drools.org/drools-5.0/process}onExit"/>
 *       &lt;/choice>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="processId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="waitForCompletion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="independent" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "metaDataOrMappingOrTimers"
})
@XmlRootElement(name = "subProcess")
public class SubProcess {

    @XmlElements({
        @XmlElement(name = "onEntry", type = OnEntry.class),
        @XmlElement(name = "timers", type = Timers.class),
        @XmlElement(name = "onExit", type = OnExit.class),
        @XmlElement(name = "metaData", type = MetaData.class),
        @XmlElement(name = "mapping", type = Mapping.class)
    })
    protected List<Object> metaDataOrMappingOrTimers;
    @XmlAttribute(required = true)
    protected String id;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected String x;
    @XmlAttribute
    protected String y;
    @XmlAttribute
    protected String width;
    @XmlAttribute
    protected String height;
    @XmlAttribute
    protected String processId;
    @XmlAttribute
    protected String waitForCompletion;
    @XmlAttribute
    protected String independent;

    /**
     * Gets the value of the metaDataOrMappingOrTimers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metaDataOrMappingOrTimers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetaDataOrMappingOrTimers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OnEntry }
     * {@link Timers }
     * {@link OnExit }
     * {@link MetaData }
     * {@link Mapping }
     * 
     * 
     */
    public List<Object> getMetaDataOrMappingOrTimers() {
        if (metaDataOrMappingOrTimers == null) {
            metaDataOrMappingOrTimers = new ArrayList<Object>();
        }
        return this.metaDataOrMappingOrTimers;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the x property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX(String value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setY(String value) {
        this.y = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeight(String value) {
        this.height = value;
    }

    /**
     * Gets the value of the processId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * Sets the value of the processId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessId(String value) {
        this.processId = value;
    }

    /**
     * Gets the value of the waitForCompletion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitForCompletion() {
        return waitForCompletion;
    }

    /**
     * Sets the value of the waitForCompletion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitForCompletion(String value) {
        this.waitForCompletion = value;
    }

    /**
     * Gets the value of the independent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndependent() {
        return independent;
    }

    /**
     * Sets the value of the independent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndependent(String value) {
        this.independent = value;
    }

}

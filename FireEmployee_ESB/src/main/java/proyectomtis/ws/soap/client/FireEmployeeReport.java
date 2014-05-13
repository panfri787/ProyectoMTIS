
package proyectomtis.ws.soap.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FireEmployeeReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FireEmployeeReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="processId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dniId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="socialSecurityProcessState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessProcessState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FireEmployeeReport", namespace = "http://www.example.org/FireEmployeeReport/", propOrder = {
    "processId",
    "dniId",
    "businessId",
    "socialSecurityProcessState",
    "businessProcessState"
})
public class FireEmployeeReport {

    protected int processId;
    @XmlElement(required = true)
    protected String dniId;
    @XmlElement(required = true)
    protected String businessId;
    @XmlElement(required = true)
    protected String socialSecurityProcessState;
    @XmlElement(required = true)
    protected String businessProcessState;

    /**
     * Gets the value of the processId property.
     * 
     */
    public int getProcessId() {
        return processId;
    }

    /**
     * Sets the value of the processId property.
     * 
     */
    public void setProcessId(int value) {
        this.processId = value;
    }

    /**
     * Gets the value of the dniId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDniId() {
        return dniId;
    }

    /**
     * Sets the value of the dniId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDniId(String value) {
        this.dniId = value;
    }

    /**
     * Gets the value of the businessId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * Sets the value of the businessId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessId(String value) {
        this.businessId = value;
    }

    /**
     * Gets the value of the socialSecurityProcessState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSocialSecurityProcessState() {
        return socialSecurityProcessState;
    }

    /**
     * Sets the value of the socialSecurityProcessState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSocialSecurityProcessState(String value) {
        this.socialSecurityProcessState = value;
    }

    /**
     * Gets the value of the businessProcessState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessProcessState() {
        return businessProcessState;
    }

    /**
     * Sets the value of the businessProcessState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessProcessState(String value) {
        this.businessProcessState = value;
    }

}

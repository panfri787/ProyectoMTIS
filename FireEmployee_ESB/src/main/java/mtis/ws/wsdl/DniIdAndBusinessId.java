
package mtis.ws.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DniIdAndBusinessId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DniIdAndBusinessId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dniId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DniIdAndBusinessId", propOrder = {
    "dniId",
    "businessId"
})
public class DniIdAndBusinessId {

    @XmlElement(namespace = "", required = true)
    protected String dniId;
    @XmlElement(namespace = "", required = true)
    protected String businessId;

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

}

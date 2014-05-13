
package proyectomtis.ws.soap.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IsOkAndFireEmployeeReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IsOkAndFireEmployeeReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isCompletedWithoutErrors" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fireEmployeeReport" type="{http://www.example.org/FireEmployeeReport/}FireEmployeeReport"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsOkAndFireEmployeeReport", propOrder = {
    "isCompletedWithoutErrors",
    "fireEmployeeReport"
})
public class IsOkAndFireEmployeeReport {

    protected boolean isCompletedWithoutErrors;
    @XmlElement(required = true)
    protected FireEmployeeReport fireEmployeeReport;

    /**
     * Gets the value of the isCompletedWithoutErrors property.
     * 
     */
    public boolean isIsCompletedWithoutErrors() {
        return isCompletedWithoutErrors;
    }

    /**
     * Sets the value of the isCompletedWithoutErrors property.
     * 
     */
    public void setIsCompletedWithoutErrors(boolean value) {
        this.isCompletedWithoutErrors = value;
    }

    /**
     * Gets the value of the fireEmployeeReport property.
     * 
     * @return
     *     possible object is
     *     {@link FireEmployeeReport }
     *     
     */
    public FireEmployeeReport getFireEmployeeReport() {
        return fireEmployeeReport;
    }

    /**
     * Sets the value of the fireEmployeeReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link FireEmployeeReport }
     *     
     */
    public void setFireEmployeeReport(FireEmployeeReport value) {
        this.fireEmployeeReport = value;
    }

}

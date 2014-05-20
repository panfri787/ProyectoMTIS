
package proyectomtis.ws.soap.fireemployeebusiness;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the proyectomtis.ws.soap.fireemployeebusiness package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IsOkAndFireEmployeeReport_QNAME = new QName("http://www.example.org/IsOkAndFireEmployeeReport/", "IsOkAndFireEmployeeReport");
    private final static QName _DniIdAndBusinessId_QNAME = new QName("http://www.example.org/DniAndBusiness/", "DniIdAndBusinessId");
    private final static QName _FireEmployeeReport_QNAME = new QName("http://www.example.org/FireEmployeeReport/", "FireEmployeeReport");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: proyectomtis.ws.soap.fireemployeebusiness
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsOkAndFireEmployeeReport }
     * 
     */
    public IsOkAndFireEmployeeReport createIsOkAndFireEmployeeReport() {
        return new IsOkAndFireEmployeeReport();
    }

    /**
     * Create an instance of {@link FireEmployeeReport }
     * 
     */
    public FireEmployeeReport createFireEmployeeReport() {
        return new FireEmployeeReport();
    }

    /**
     * Create an instance of {@link DniIdAndBusinessId }
     * 
     */
    public DniIdAndBusinessId createDniIdAndBusinessId() {
        return new DniIdAndBusinessId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsOkAndFireEmployeeReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/IsOkAndFireEmployeeReport/", name = "IsOkAndFireEmployeeReport")
    public JAXBElement<IsOkAndFireEmployeeReport> createIsOkAndFireEmployeeReport(IsOkAndFireEmployeeReport value) {
        return new JAXBElement<IsOkAndFireEmployeeReport>(_IsOkAndFireEmployeeReport_QNAME, IsOkAndFireEmployeeReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DniIdAndBusinessId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/DniAndBusiness/", name = "DniIdAndBusinessId")
    public JAXBElement<DniIdAndBusinessId> createDniIdAndBusinessId(DniIdAndBusinessId value) {
        return new JAXBElement<DniIdAndBusinessId>(_DniIdAndBusinessId_QNAME, DniIdAndBusinessId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FireEmployeeReport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/FireEmployeeReport/", name = "FireEmployeeReport")
    public JAXBElement<FireEmployeeReport> createFireEmployeeReport(FireEmployeeReport value) {
        return new JAXBElement<FireEmployeeReport>(_FireEmployeeReport_QNAME, FireEmployeeReport.class, null, value);
    }

}

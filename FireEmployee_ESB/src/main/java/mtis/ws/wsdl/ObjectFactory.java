
package mtis.ws.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mtis.ws.wsdl package. 
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

    private final static QName _DniIdAndBusinessId_QNAME = new QName("http://www.example.org/DniAndBusiness/", "DniIdAndBusinessId");
    private final static QName _BoolResponse_QNAME = new QName("http://www.example.org/BoolResponse/", "BoolResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mtis.ws.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DniIdAndBusinessId }
     * 
     */
    public DniIdAndBusinessId createDniIdAndBusinessId() {
        return new DniIdAndBusinessId();
    }

    /**
     * Create an instance of {@link BoolResponse }
     * 
     */
    public BoolResponse createBoolResponse() {
        return new BoolResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BoolResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/BoolResponse/", name = "BoolResponse")
    public JAXBElement<BoolResponse> createBoolResponse(BoolResponse value) {
        return new JAXBElement<BoolResponse>(_BoolResponse_QNAME, BoolResponse.class, null, value);
    }

}

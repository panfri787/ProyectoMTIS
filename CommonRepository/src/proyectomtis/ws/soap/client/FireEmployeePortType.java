package proyectomtis.ws.soap.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * This class was generated by Apache CXF 3.0.0-milestone2
 * 2014-05-13T01:43:07.411+02:00
 * Generated source version: 3.0.0-milestone2
 * 
 */
@WebService(targetNamespace = "http://www.example.org/FireEmployee/", name = "FireEmployeePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface FireEmployeePortType {

    @WebResult(name = "IsOkAndFireEmployeeReport", targetNamespace = "http://www.example.org/IsOkAndFireEmployeeReport/", partName = "IsOkAndFireEmployeeReport")
    @Action(input = "http://www.example.org/FireEmployee/FireEmployee", output = "http://www.example.org/FireEmployee/FireEmployee/FireEmployeeResponse")
    @WebMethod(operationName = "FireEmployee", action = "http://www.example.org/FireEmployee/FireEmployee")
    public IsOkAndFireEmployeeReport fireEmployee(
        @WebParam(partName = "DniIdAndBusinessId", name = "DniIdAndBusinessId", targetNamespace = "http://www.example.org/DniAndBusiness/")
        DniIdAndBusinessId dniIdAndBusinessId
    );
}

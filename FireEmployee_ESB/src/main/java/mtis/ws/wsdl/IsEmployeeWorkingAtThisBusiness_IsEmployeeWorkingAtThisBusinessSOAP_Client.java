
package mtis.ws.wsdl;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.5.1
 * 2014-05-26T21:55:05.284+02:00
 * Generated source version: 2.5.1
 * 
 */
public final class IsEmployeeWorkingAtThisBusiness_IsEmployeeWorkingAtThisBusinessSOAP_Client {

    private static final QName SERVICE_NAME = new QName("http://www.example.org/isEmployeeWorkingAtThisBusiness/", "isEmployeeWorkingAtThisBusiness");

    private IsEmployeeWorkingAtThisBusiness_IsEmployeeWorkingAtThisBusinessSOAP_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = IsEmployeeWorkingAtThisBusiness_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        IsEmployeeWorkingAtThisBusiness_Service ss = new IsEmployeeWorkingAtThisBusiness_Service(wsdlURL, SERVICE_NAME);
        IsEmployeeWorkingAtThisBusiness port = ss.getIsEmployeeWorkingAtThisBusinessSOAP();  
        
        {
        System.out.println("Invoking isEmployeeWorkingAtThisBusiness...");
        mtis.ws.wsdl.DniIdAndBusinessId _isEmployeeWorkingAtThisBusiness_dniIdAndBusinessId = null;
        mtis.ws.wsdl.BoolResponse _isEmployeeWorkingAtThisBusiness__return = port.isEmployeeWorkingAtThisBusiness(_isEmployeeWorkingAtThisBusiness_dniIdAndBusinessId);
        System.out.println("isEmployeeWorkingAtThisBusiness.result=" + _isEmployeeWorkingAtThisBusiness__return);


        }

        System.exit(0);
    }

}

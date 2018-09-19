
package localhost._8080.namegenerator;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "NameGeneratorServiceImplService", targetNamespace = "http://localhost:8080/NameGenerator", wsdlLocation = "http://localhost:8080/NameGeneratorService?WSDL")
public class NameGeneratorServiceImplService
    extends Service
{

    private final static URL NAMEGENERATORSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException NAMEGENERATORSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName NAMEGENERATORSERVICEIMPLSERVICE_QNAME = new QName("http://localhost:8080/NameGenerator", "NameGeneratorServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/NameGeneratorService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NAMEGENERATORSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        NAMEGENERATORSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public NameGeneratorServiceImplService() {
        super(__getWsdlLocation(), NAMEGENERATORSERVICEIMPLSERVICE_QNAME);
    }

    public NameGeneratorServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), NAMEGENERATORSERVICEIMPLSERVICE_QNAME, features);
    }

    public NameGeneratorServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, NAMEGENERATORSERVICEIMPLSERVICE_QNAME);
    }

    public NameGeneratorServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NAMEGENERATORSERVICEIMPLSERVICE_QNAME, features);
    }

    public NameGeneratorServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NameGeneratorServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NameGeneratorService
     */
    @WebEndpoint(name = "NameGeneratorServicePort")
    public NameGeneratorService getNameGeneratorServicePort() {
        return super.getPort(new QName("http://localhost:8080/NameGenerator", "NameGeneratorServicePort"), NameGeneratorService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NameGeneratorService
     */
    @WebEndpoint(name = "NameGeneratorServicePort")
    public NameGeneratorService getNameGeneratorServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://localhost:8080/NameGenerator", "NameGeneratorServicePort"), NameGeneratorService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NAMEGENERATORSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw NAMEGENERATORSERVICEIMPLSERVICE_EXCEPTION;
        }
        return NAMEGENERATORSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}

package com.accenture.flowershop.be.business;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.accenture.flowershop.be.business package. 
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

    private final static QName _IncreaseFlowerStockSize_QNAME = new QName("http://business.be.flowershop.accenture.com/", "increaseFlowerStockSize");
    private final static QName _IncreaseFlowerStockSizeResponse_QNAME = new QName("http://business.be.flowershop.accenture.com/", "increaseFlowerStockSizeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.accenture.flowershop.be.business
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IncreaseFlowerStockSize }
     * 
     */
    public IncreaseFlowerStockSize createIncreaseFlowerStockSize() {
        return new IncreaseFlowerStockSize();
    }

    /**
     * Create an instance of {@link IncreaseFlowerStockSizeResponse }
     * 
     */
    public IncreaseFlowerStockSizeResponse createIncreaseFlowerStockSizeResponse() {
        return new IncreaseFlowerStockSizeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncreaseFlowerStockSize }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.be.flowershop.accenture.com/", name = "increaseFlowerStockSize")
    public JAXBElement<IncreaseFlowerStockSize> createIncreaseFlowerStockSize(IncreaseFlowerStockSize value) {
        return new JAXBElement<IncreaseFlowerStockSize>(_IncreaseFlowerStockSize_QNAME, IncreaseFlowerStockSize.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncreaseFlowerStockSizeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business.be.flowershop.accenture.com/", name = "increaseFlowerStockSizeResponse")
    public JAXBElement<IncreaseFlowerStockSizeResponse> createIncreaseFlowerStockSizeResponse(IncreaseFlowerStockSizeResponse value) {
        return new JAXBElement<IncreaseFlowerStockSizeResponse>(_IncreaseFlowerStockSizeResponse_QNAME, IncreaseFlowerStockSizeResponse.class, null, value);
    }

}

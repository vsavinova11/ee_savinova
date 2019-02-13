
package com.accenture.flowershop.be.business;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FlowerStockWebService", targetNamespace = "http://business.be.flowershop.accenture.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FlowerStockWebService {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "increaseFlowerStockSize", targetNamespace = "http://business.be.flowershop.accenture.com/", className = "com.accenture.flowershop.be.business.IncreaseFlowerStockSize")
    @ResponseWrapper(localName = "increaseFlowerStockSizeResponse", targetNamespace = "http://business.be.flowershop.accenture.com/", className = "com.accenture.flowershop.be.business.IncreaseFlowerStockSizeResponse")
    public void increaseFlowerStockSize(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
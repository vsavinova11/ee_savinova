/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.fe.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class DiscountRequest {

    private Long customerId;
    private int newDiscount;

    public Long getCustomerId() {
        return customerId;
    }

    @XmlElement
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getNewDiscount() {
        return newDiscount;
    }

    @XmlElement
    public void setNewDiscount(int newDiscount) {
        this.newDiscount = newDiscount;
    }

}

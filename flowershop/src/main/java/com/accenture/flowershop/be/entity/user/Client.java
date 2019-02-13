package com.accenture.flowershop.be.entity.user;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Client extends User {
    private String fullName;
    private String address;
    private String phone;
    private BigDecimal balance;
    private int discount;

    public Client() {

    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getDiscount() {
        return discount;
    }
    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    @XmlElement
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    @XmlElement
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

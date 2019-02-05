package com.accenture.flowershop.be.entity.user;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Client extends User {
    private String fullName;
    private String address;
    private String phone;
    private BigDecimal balance;
    private int discount;

    Client() {

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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

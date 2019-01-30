package com.accenture.flowershop.be.entity.user;

import javax.persistence.Entity;

@Entity
public class Client extends User {
    private String fullName;
    private String address;
    private String phone;
    private double balance;
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

    public double getBalance() {
        return balance;
    }

    public int getDiscount() {
        return discount;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBalance(double balance) {
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

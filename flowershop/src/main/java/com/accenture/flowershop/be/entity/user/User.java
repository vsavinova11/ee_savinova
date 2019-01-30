package com.accenture.flowershop.be.entity.user;

import com.accenture.flowershop.be.entity.PersistentEntity;

import javax.persistence.Entity;

@Entity
public abstract class User extends PersistentEntity {
    private String login;
    private String password;

    User(){

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

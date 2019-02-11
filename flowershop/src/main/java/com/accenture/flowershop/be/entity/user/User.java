package com.accenture.flowershop.be.entity.user;

import com.accenture.flowershop.be.entity.PersistentEntity;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity

public abstract class User extends PersistentEntity {
    @Column(length = 64, nullable = false)
    private String login;
    @Column(length = 64, nullable = false)
    private String password;

    User() {
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

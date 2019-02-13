/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.user.Client;

public interface ClientMarshallingService {
    public void saveToFile(Client client);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.be.business;

import javax.jws.WebService;


@WebService
public interface FlowerStockWebService {
    void increaseFlowerStockSize(int count);
}

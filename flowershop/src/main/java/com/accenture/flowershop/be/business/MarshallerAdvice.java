/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.user.Client;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MarshallerAdvice {
    
    @Autowired
    private ClientMarshallingService clientMarshallingService;
    
    @AfterReturning(value="execution(* com.accenture.flowershop.be.business.ClientService.addClient(..))", returning = "client")
    public void afterRegistration(Client client)
    {
        if(client!=null)
        {
            clientMarshallingService.saveToFile(client);
        }
    }
}

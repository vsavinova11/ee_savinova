/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.startup;

import com.accenture.flowershop.be.business.FlowerStockWebService;
import com.accenture.flowershop.be.business.FlowerStockWebServiceImplService;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Startup {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        FlowerStockWebServiceImplService service = new FlowerStockWebServiceImplService();
        FlowerStockWebService ws = service.getFlowerStockWebServiceImplPort();
        executor.scheduleAtFixedRate(()
                -> {
            Random r = new Random(System.currentTimeMillis());
            ws.increaseFlowerStockSize(10 + r.nextInt(21));
        }, 10, 10, TimeUnit.MINUTES);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                executor.shutdown();
            }
        });
    }
}
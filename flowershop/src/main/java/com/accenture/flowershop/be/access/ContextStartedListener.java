package com.accenture.flowershop.be.access;


import com.accenture.flowershop.be.entity.user.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStartedListener implements ApplicationListener<ContextStartedEvent> {
    @Autowired
    AdminService adminService;
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        Admin admin = adminService.findAdmin("admin");
        if (admin == null){
            admin = new Admin();
            admin.setLogin("admin");
            admin.setPassword("admin123");
            adminService.addAdmin(admin);
        }
    }
}

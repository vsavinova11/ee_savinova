package com.accenture.flowershop.be.config;


import com.accenture.flowershop.be.business.AdminService;
import com.accenture.flowershop.be.entity.user.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextStartedListener{
    @Autowired
    private AdminService adminService;
    
    
    @EventListener({ContextRefreshedEvent.class})
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String contextId = event.getApplicationContext().getId();
        if(!contextId.endsWith("/dispatcher"))
            return;
        Admin admin = adminService.findAdmin("admin");
        if (admin == null){
            admin = new Admin();
            admin.setLogin("admin");
            admin.setPassword("$2a$10$OYlImfEAiFSolcXmR/SOT.FwYt346HCU8asMLXqrwMRGV8Z1SF5py");
            adminService.addAdmin(admin);
        }
    }
}

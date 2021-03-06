package com.accenture.flowershop.be.controller;

import com.accenture.flowershop.be.business.ClientService;
import com.accenture.flowershop.be.entity.user.Client;
import com.accenture.flowershop.fe.dto.ClientInfo;
import com.accenture.flowershop.fe.dto.RegistrationReply;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView registrationPage() {
        ModelAndView mv = new ModelAndView("registration");
        mv.addObject("client", new ClientInfo());
        mv.addObject("error", "No error");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("client") ClientInfo clientInfo, ModelAndView data) {
        Client client = clientService.addClient(clientInfo);
        if (client == null) {
            data.addObject("error", "Failed to register");
            return data;
        }

        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/check")
    @ResponseBody
    public RegistrationReply checkLogin(@RequestParam("login") String login) {
        RegistrationReply reply = new RegistrationReply();
        Client cl = clientService.findByLogin(login);
        reply.setLoginExists(cl != null);
        return reply;
    }
}

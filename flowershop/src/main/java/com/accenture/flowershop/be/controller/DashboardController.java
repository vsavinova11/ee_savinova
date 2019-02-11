package com.accenture.flowershop.be.controller;

import com.accenture.flowershop.be.business.ClientOrderService;
import com.accenture.flowershop.be.entity.order.ClientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    ClientOrderService clientOrderService;

    @RequestMapping()
    public ModelAndView getIndex(ModelAndView modelAndView,
                                 HttpSession session,
                                 @RequestParam(required = false, value = "column")String column,
                                 @RequestParam(required = false, value = "direction") Sort.Direction direction) {
        modelAndView.setViewName("dashboard");
        List<ClientOrder> clientOrders;
        if(column!=null&&direction!=null)
        {
            clientOrders = clientOrderService.findAllClientOrders(column, direction);
        }
        else
        {
            clientOrders = clientOrderService.findAllClientOrders();
        }
        modelAndView.addObject("clientOrders", clientOrders);
        return modelAndView;
    }

    @RequestMapping("/close")
    public ModelAndView closeOrder(ModelAndView modelAndView, HttpSession session, @RequestParam("id") Long id) {
        try {
            clientOrderService.closeOrder(id);
            modelAndView.setViewName("redirect:../dashboard");
            session.removeAttribute("error");
            return modelAndView;
        } catch (RuntimeException e) {
            session.setAttribute("error", e.getMessage());
            modelAndView.setViewName("redirect:../dashboard");
            return modelAndView;
        }
    }


}
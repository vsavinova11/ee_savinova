package com.accenture.flowershop.be.controller;

import com.accenture.flowershop.be.business.CartService;
import com.accenture.flowershop.be.business.ClientOrderService;
import com.accenture.flowershop.be.business.ClientService;
import com.accenture.flowershop.be.business.FlowerService;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.ClientOrder;
import com.accenture.flowershop.be.entity.user.Client;
import com.accenture.flowershop.fe.dto.CartDto;
import com.accenture.flowershop.fe.dto.ErrorDto;
import com.accenture.flowershop.fe.dto.ItemInfo;
import java.util.ArrayList;

import com.accenture.flowershop.fe.dto.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private FlowerService flowerService;
    @Autowired
    private ClientOrderService clientOrderService;
    @Autowired
    private CartService cartService;

    @RequestMapping()
    public ModelAndView getIndex(ModelAndView modelAndView,
                                 HttpSession session,
                                 @ModelAttribute("searchInfo") SearchDto searchInfo) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Client client = clientService.findByLogin(principal.getUsername());
        List<Flower> flowers = searchInfo==null?flowerService.listFlower():
                flowerService.listFlowers(searchInfo.getName(), searchInfo.getFrom(), searchInfo.getTo());
        modelAndView.setViewName("index");
        if (client == null) {
            session.setAttribute("error", new ErrorDto("Failed to load client"));
        } else {
            List<ClientOrder> clientOrders = clientOrderService.findClientOrders(client);
            modelAndView.addObject("client", client);
            modelAndView.addObject("flowers", flowers);
            modelAndView.addObject("clientOrders", clientOrders);
            modelAndView.addObject("itemInfo", new ItemInfo());
            modelAndView.addObject("searchInfo", searchInfo == null?new SearchDto():searchInfo);

        }
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/flower/add")
    public ModelAndView addFlowerToCart(@ModelAttribute("itemInfo") ItemInfo info,
            ModelAndView modelAndView, HttpSession session) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Client client = clientService.findByLogin(principal.getUsername());
        CartDto cartInfo = (CartDto) session.getAttribute("cartInfo");
        if(cartInfo == null)
        {
            cartInfo = new CartDto();
            cartInfo.setCart(new ArrayList<>());
            cartInfo.setTotal(0.0);
            session.setAttribute("cartInfo", cartInfo);
        }
        try {
            cartInfo.setCart(cartService.addFlowerToCart(cartInfo.getCart(), info.getId(), info.getCount()));
            cartInfo.setTotal(cartService.getTotal(cartInfo.getCart(), client.getDiscount()));
        }
        catch (RuntimeException e){
            session.setAttribute("error", new ErrorDto(e.getMessage()));
            modelAndView.setViewName("redirect:..");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:..");
        session.removeAttribute("error");
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/order/add")
    public ModelAndView addOrder(ModelAndView modelAndView, HttpSession session) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Client client = clientService.findByLogin(principal.getUsername());
        CartDto cartInfo = (CartDto)session.getAttribute("cartInfo");
        if(cartInfo == null)
        {
            modelAndView.addObject("error", "Failed to create order");
        }
        else{

            clientOrderService.addClientOrder(client, cartInfo.getCart(), cartInfo.getTotal());
            session.removeAttribute("cartInfo");
        }
        modelAndView.setViewName("redirect:..");
        return modelAndView;
    }

    @RequestMapping(value = "/order/pay")
    public ModelAndView payOrder(ModelAndView modelAndView, HttpSession session, @RequestParam("id") Long id){
        try {
            clientOrderService.orderPay(id);
            modelAndView.setViewName("redirect:..");
            session.removeAttribute("error");
            return modelAndView;
        }
        catch (RuntimeException e){
            session.setAttribute("error", new ErrorDto(e.getMessage()));
            modelAndView.setViewName("redirect:..");
            return modelAndView;
        }
    }

}

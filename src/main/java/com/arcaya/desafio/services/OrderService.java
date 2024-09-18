package com.arcaya.desafio.services;

import com.arcaya.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total (Order order){
        double priceWithDiscount = order.getBasic() -  (order.getBasic() * (order.getDiscount() / 100));
        return priceWithDiscount + shippingService.shipment(order);
    }

}

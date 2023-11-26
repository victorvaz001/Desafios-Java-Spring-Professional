package com.victor.desafio.services;

import com.victor.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total (Order order){

        double total =  order.getBasic() - (order.getBasic() * order.getDiscount() / 100.0);
        return total  + shippingService.shipment(order);
    }
}

package com.victor.desafio.services;

import com.victor.desafio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public double total (Order order){
        return order.getBasic() * order.getDiscount() / 100.00;
    }
}

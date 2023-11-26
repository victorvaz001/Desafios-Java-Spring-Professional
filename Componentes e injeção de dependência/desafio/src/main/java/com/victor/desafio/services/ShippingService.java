package com.victor.desafio.services;

import com.victor.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {

        Double shipment = 0.0;
        if (order.getBasic() < 100.0){
            shipment =  20.00;
        }
        else if (order.getBasic() <= 200.0){
            shipment = 12.00;
        }

        return  shipment;
    }
}

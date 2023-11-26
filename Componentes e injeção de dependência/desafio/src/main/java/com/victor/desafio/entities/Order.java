package com.victor.desafio.entities;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {

    private Integer code;
    private Double basic;
    private Double discount;

    public Order (){
    }

    public Order(Integer code, Double basic, Double discount) {
        this.code = code;
        this.basic = basic;
        this.discount = discount;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double basic) {
        this.basic = basic;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(code, order.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

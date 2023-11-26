package com.victor.desafio;

import com.victor.desafio.entities.Order;
import com.victor.desafio.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.Format;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

    Scanner sc = new Scanner(System.in);
    @Autowired
    OrderService orderService;

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        SpringApplication.run(DesafioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Order order = new Order();

        System.out.println("Informe os dados do pedido:");

        System.out.print("Codigo: ");
        int codigo = sc.nextInt();

        System.out.print("Valor básico: ");
        double valorBasico = sc.nextDouble();

        System.out.print("Porcentagem de desconto: ");
        double porcentagemDesconto = sc.nextDouble();

        order.setCode(codigo);
        order.setBasic(valorBasico);
        order.setDiscount(porcentagemDesconto);

        System.out.println("Pedido código " + order.getCode());
        System.out.printf("Valor total: R$ %.2f" , orderService.total(order));

    }
}

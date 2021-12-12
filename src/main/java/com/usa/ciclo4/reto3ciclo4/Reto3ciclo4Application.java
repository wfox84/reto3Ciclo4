package com.usa.ciclo4.reto3ciclo4;


import com.usa.ciclo4.reto3ciclo4.repository.crud.OrderCrudRepository;
import com.usa.ciclo4.reto3ciclo4.repository.crud.ProductCrudRepository;
import com.usa.ciclo4.reto3ciclo4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Component
@SpringBootApplication
public class Reto3ciclo4Application implements CommandLineRunner {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(Reto3ciclo4Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        userCrudRepository.deleteAll();
        productCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }

}

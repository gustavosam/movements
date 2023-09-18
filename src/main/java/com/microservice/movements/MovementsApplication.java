package com.microservice.movements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Esta es la clase principal de movimientos.
 * */
@EnableDiscoveryClient
@SpringBootApplication
public class MovementsApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovementsApplication.class, args);
  }

}

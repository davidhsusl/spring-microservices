package com.microservices.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CalculatePremApplication2 {

  public static void main(String[] args) {
    SpringApplication.run(CalculatePremApplication2.class, args);
  }
}

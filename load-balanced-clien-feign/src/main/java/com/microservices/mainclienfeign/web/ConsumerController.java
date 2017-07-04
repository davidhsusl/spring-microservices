package com.microservices.mainclienfeign.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

  @Autowired private CalculatePremClient calculatePremClient;

  @RequestMapping(value = "/calculate/{a}/{b}", method = RequestMethod.GET)
  public Integer add(@PathVariable Integer a, @PathVariable Integer b) {
    return calculatePremClient.calculate(a, b);
  }
}

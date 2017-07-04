package com.microservices.mainclienfeign.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author David Hsu
 * @since 2017/07/04
 */
@FeignClient("calculate-prem-service")
public interface CalculatePremClient {

  @RequestMapping(method = RequestMethod.GET, value = "/calculate/{a}/{b}")
  String calculate(@PathVariable("a") Integer a, @PathVariable("b") Integer b);
}

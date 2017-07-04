package com.microservices.client2.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author David Hsu
 * @since 2017/07/04
 */
@RestController
public class CalculatePremController {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired private DiscoveryClient discoveryClient;

  @Autowired private Registration registration;

  @RequestMapping(value = "/calculate/{a}/{b}", method = RequestMethod.GET)
  public String calculate(@PathVariable Integer a, @PathVariable Integer b) {
    List<ServiceInstance> instances = discoveryClient.getInstances(registration.getServiceId());
    Integer r = a + b;

    if (!CollectionUtils.isEmpty(instances)) {
      ServiceInstance instance = instances.get(0);
      log.info(
          "/calculate, host:"
              + instance.getHost()
              + ", service_id:"
              + instance.getServiceId()
              + ", num: "
              + instances.size()
              + ", result:"
              + r);
    }

    return "Prem is " + r + ", calculated by CALCULATE-PREM-SERVICE2";
  }
}

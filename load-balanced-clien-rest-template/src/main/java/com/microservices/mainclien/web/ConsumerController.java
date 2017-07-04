package com.microservices.mainclien.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author David Hsu
 * @since 2017/07/04
 */
@RestController
public class ConsumerController {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired private DiscoveryClient discoveryClient;

  @Autowired private RestTemplate restTemplate;

  @RequestMapping("/calculate/{a}/{b}")
  public String calculate(@PathVariable String a, @PathVariable String b) {
    URI uri =
        UriComponentsBuilder.fromHttpUrl("http://calculate-prem-service/calculate/{a}/{b}")
            .buildAndExpand(a, b)
            .toUri();

    String location = restTemplate.getForEntity(uri, String.class).getBody();
    log.info("location to: {}", location);

    return location;
  }
}

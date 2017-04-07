package com.techprimers.cloud.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloResource.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/client")
    public String hello() {

        LOGGER.info("Before Calling the Server");
        String response = restTemplate.getForObject("http://localhost:8083/rest/hello/server", String.class);
        LOGGER.info("After Calling the Server");

        return response;
    }
}

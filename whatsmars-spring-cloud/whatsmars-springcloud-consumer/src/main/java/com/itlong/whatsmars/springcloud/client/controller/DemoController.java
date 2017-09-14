package com.itlong.whatsmars.springcloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shenhongxi on 2017/9/14.
 */
@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${foo}")
    private String foo;

    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println(foo);
        return restTemplate.getForObject("http://demo-server/hello?name=" + name, String.class);
    }
}

package spring.cloud.demo.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("hello")
    public String hello() {
        String content = restTemplate.getForObject("http://gateway/provider/hello", String.class);
        return content + System.currentTimeMillis();
    }

}

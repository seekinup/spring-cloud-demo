package spring.cloud.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.SimpleFormatter;

@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("hello")
    public String hello() {
        //启用负载均需要需要以应用名称访问
        String content = restTemplate.getForObject("http://gateway/provider/hello", String.class);
        return LocalDateTime.now() + " " + content;
    }

}

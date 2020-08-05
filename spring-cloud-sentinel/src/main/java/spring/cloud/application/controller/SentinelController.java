package spring.cloud.application.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SentinelController {

    @SentinelResource("hello")
    @GetMapping("hello")
    public String hello(){

        return "hello world!";
    }
}

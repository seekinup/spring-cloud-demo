package spring.cloud.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    @RequestMapping("mock")
    public String hello() {
        return "mockmvc";
    }
}

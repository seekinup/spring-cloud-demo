package spring.cloud.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
public class FeignController {

    @RequestMapping("test")
    public String test(){
        return "be called by feign";
    }
}

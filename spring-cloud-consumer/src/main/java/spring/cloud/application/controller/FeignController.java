package spring.cloud.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    //采用FeignClient的形式调用
    @RequestMapping("feign/test")
    public String test() {
        String content = feignService.test();
        return LocalDateTime.now() + "  " + content;
    }
}

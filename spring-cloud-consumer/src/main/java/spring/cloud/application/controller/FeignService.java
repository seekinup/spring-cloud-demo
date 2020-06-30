package spring.cloud.application.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 允许feign客户端
 * 按照调用服务的结构定义访问接口
 */
@FeignClient("provider")
public interface FeignService {

    @GetMapping("feign/test")
    String test();
}

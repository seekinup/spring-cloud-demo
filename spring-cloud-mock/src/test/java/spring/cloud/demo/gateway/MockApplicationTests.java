package spring.cloud.demo.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.Assert;
import spring.cloud.application.MockApplication;

//注册mockmvc
@AutoConfigureMockMvc
//随机端口启动另一个服务，并声明测试的启动类
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MockApplication.class)
class MockApplicationTests {

    @Test
    void testMockMvc(@Autowired MockMvc mockMvc) throws Exception {
        //单元测试，支持系统内部模块
        mockMvc.perform(MockMvcRequestBuilders.get("/mock"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


    @Test
    void testRestTemplate(@Autowired TestRestTemplate restTemplate) {
        //没有指明全路径在当前系统匹配，支持外部接口测试
//		String result = restTemplate.getForObject("/mock", String.class);
        String result = restTemplate.getForObject("http://localhost:8070/gateway/consumer/feign/test", String.class);
        System.out.println("----------------->" + result);
        Assert.isTrue("mockmvc".equals(result), "报文不匹配");
    }

}

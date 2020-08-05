package spring.cloud.demo.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import spring.cloud.application.SentinelApplication;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SentinelApplication.class)
class GatewayApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/feign/test"))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		System.out.println(result);
	}

	@Test
	void contextLoads0(@Autowired TestRestTemplate restTemplate) throws Exception {
		String body = restTemplate.getForObject("http://127.0.0.1:8070/provider/hello", String.class);
		System.out.println(body);

	}

	@Test
	void exampleTest(@Autowired WebTestClient webClient) {
		webClient.get().uri("/hello").exchange().expectStatus().isOk().expectBody(String.class).returnResult();
	}

}

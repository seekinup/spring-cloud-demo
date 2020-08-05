package spring.cloud.application.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        //从代码结构看来,一个FilterRegistrationBean只能注册一个过滤器
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}

package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import web.handler.RoutingServlet;

@SpringBootApplication(scanBasePackages = "web")
public class MyServer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyServer.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyServer.class, args);
    }

    @Bean
    public ServletRegistrationBean<RoutingServlet> routingServletRegistration() {
        ServletRegistrationBean<RoutingServlet> registration =
                new ServletRegistrationBean<RoutingServlet>(new RoutingServlet());

        registration.addUrlMappings(
                "/",
                "/login",
                "/q1",
                "/q2",
                "/q3",
                "/date1",
                "/date2",
                "/science",
                "/complete"
        );

        registration.setName("RoutingServlet");
        registration.setLoadOnStartup(1);

        return registration;
    }
}
package com.goit.wallet.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                    .path("/quotes/random")
                    .filters(f ->
                            f.addRequestHeader(	"x-rapidapi-host", "quotes15.p.rapidapi.com")
                                    .addRequestHeader("x-rapidapi-key", "a282ea5fb5msh309fb4230669cddp1ab260jsnd880947891ad")
                    )
                    .uri("https://quotes15.p.rapidapi.com")
                )
                .route(p -> p
                    .path("/get")
                    .filters(f -> f.addRequestHeader("Hello", "World"))
                    .uri("http://httpbin.org:80"))
                .route(p -> p
                    .host("*.hystrix.com")
                    .filters(f -> f.hystrix(config -> config.setName("mycmd")))
                    .uri("http://httpbin.org:80"))
                .build();
    }
}

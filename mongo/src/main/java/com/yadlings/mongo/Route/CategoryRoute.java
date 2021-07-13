package com.yadlings.mongo.Route;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
@EnableWebFlux
public class CategoryRoute {

    @Bean
    public RouterFunction<ServerResponse> Route(){
        return RouterFunctions.route()
                .GET()
                .GET()
                .PUT()
                .POST()
                .DELETE()
                .DELETE()
    }
}

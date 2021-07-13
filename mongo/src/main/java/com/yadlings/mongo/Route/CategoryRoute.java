package com.yadlings.mongo.Route;

import com.yadlings.mongo.Handle.CategoryHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
@EnableWebFlux
public class CategoryRoute {
    @Autowired
    private CategoryHandle categoryHandle;
    @Bean
    public RouterFunction<ServerResponse> Route(){
        return RouterFunctions.route()
                .GET("/Category",categoryHandle::getAll)
                .GET("/Category/{id}",categoryHandle::getById)
                .PUT("/Category/{id}",categoryHandle::update)
                .POST("/Category",categoryHandle::insert)
                .DELETE("/Category",categoryHandle::deleteAll)
                .DELETE("/Category/{id}",categoryHandle::deleteById)
                .build();
    }
}

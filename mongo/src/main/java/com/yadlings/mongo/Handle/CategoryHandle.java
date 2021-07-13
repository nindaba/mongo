package com.yadlings.mongo.Handle;

import com.yadlings.mongo.Documents.Category;
import com.yadlings.mongo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

@Service
public class CategoryHandle {
    @Autowired
    private CategoryRepository categoryRepository;

    public ServerResponse getAll(ServerRequest request){
        return ServerResponse
                .status(200)
                .body(categoryRepository.findAll(),Category.class)
                .block();
    }
}

package com.yadlings.mongo.Handle;

import com.yadlings.mongo.Documents.Category;
import com.yadlings.mongo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class CategoryHandle {
    @Autowired
    private CategoryRepository categoryRepository;

    public Mono<ServerResponse> getAll(ServerRequest request){
        return ServerResponse
                .status(200)
                .body(categoryRepository.findAll(),Category.class);
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        return ServerResponse
                .status(200)
                .body(categoryRepository.findById(serverRequest.pathVariable("id")),Category.class);
    }

    public Mono<ServerResponse> deleteAll(ServerRequest serverRequest) {
        return ServerResponse
                .status(200)
                .body(categoryRepository.deleteAll(),Void.class);
    }

    public Mono<ServerResponse> deleteById(ServerRequest serverRequest) {
        return ServerResponse
                .status(200)
                .body(categoryRepository.deleteById(serverRequest.pathVariable("id")),Void.class);
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .body(
                        serverRequest.bodyToMono(Category.class)
                                .flatMap(newCategory->{
                                    return categoryRepository.findById(serverRequest.pathVariable("id"))
                                            .flatMap(category->{
                                                newCategory.setId(category.getId());
                                                return categoryRepository.save(newCategory);
                                            });

                                }),
                        Category.class
                );

    }
    public Mono<ServerResponse> insert(ServerRequest serverRequest) {
        return ServerResponse
                .status(200)
                .body(serverRequest.bodyToMono(Category.class)
                        .flatMap(categoryRepository::insert),
                        Category.class);
    }
}

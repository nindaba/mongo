package com.yadlings.mongo.Repository;

import com.yadlings.mongo.Documents.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CategoryRepository extends ReactiveMongoRepository<Category,String> {
    Mono<Category> findCategoryByTitle(String title);
}

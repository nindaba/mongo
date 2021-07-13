package com.yadlings.mongo.Repository;

import com.yadlings.mongo.Documents.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category,String> {
}

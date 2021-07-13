package com.yadlings.mongo.Repository;

import com.yadlings.mongo.Documents.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
}

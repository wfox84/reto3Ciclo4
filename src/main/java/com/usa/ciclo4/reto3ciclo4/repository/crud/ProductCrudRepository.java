package com.usa.ciclo4.reto3ciclo4.repository.crud;


import com.usa.ciclo4.reto3ciclo4.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCrudRepository extends MongoRepository <CleaningProduct, Integer> {

}

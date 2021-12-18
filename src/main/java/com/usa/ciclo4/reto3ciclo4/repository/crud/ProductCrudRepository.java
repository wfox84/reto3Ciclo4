package com.usa.ciclo4.reto3ciclo4.repository.crud;


import com.usa.ciclo4.reto3ciclo4.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductCrudRepository extends MongoRepository <CleaningProduct, Integer> {

    public List<CleaningProduct> findByPrice(Double price);
    //public List<CleaningProduct> findByPriceLessThanEqual
    public List<CleaningProduct> findByDescriptionContainingIgnoreCase(String description);
}

package com.usa.ciclo4.reto3ciclo4.repository;


import com.usa.ciclo4.reto3ciclo4.model.CleaningProduct;
import com.usa.ciclo4.reto3ciclo4.repository.crud.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    public List<CleaningProduct>getAll(){
        return productCrudRepository.findAll();
    }

    public Optional<CleaningProduct> getProduct(int id){
        return productCrudRepository.findById(id);
    }

    public CleaningProduct save(CleaningProduct cleaningProduct){
        return productCrudRepository.save(cleaningProduct);
    }

    public void update(CleaningProduct cleaningProduct){
        productCrudRepository.save(cleaningProduct);
    }

    public void delete(CleaningProduct cleaningProduct){
        productCrudRepository.delete(cleaningProduct);
    }
}

package com.usa.ciclo4.reto3ciclo4.service;


import com.usa.ciclo4.reto3ciclo4.model.CleaningProduct;
import com.usa.ciclo4.reto3ciclo4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<CleaningProduct> getAll(){
        return productRepository.getAll();
    }

    public Optional<CleaningProduct> getProduct(int id){
        return productRepository.getProduct(id);
    }

    public CleaningProduct save(CleaningProduct cleaningProduct){
        if(cleaningProduct.getId() == null) {
            return cleaningProduct;
        }
        return productRepository.save(cleaningProduct);
    }

    public CleaningProduct update(CleaningProduct cleaningProduct) {

        if (cleaningProduct.getId() != null) {
            Optional<CleaningProduct> dbProduct = productRepository.getProduct(cleaningProduct.getId());
            if (!dbProduct.isEmpty()) {
                if (cleaningProduct.getBrand() != null) {
                    dbProduct.get().setBrand(cleaningProduct.getBrand());
                }
                if (cleaningProduct.getCategory() != null) {
                    dbProduct.get().setCategory(cleaningProduct.getCategory());
                }
                if (cleaningProduct.getDescription() != null) {
                    dbProduct.get().setDescription(cleaningProduct.getDescription());
                }
                if (cleaningProduct.getPrice() != 0.0) {
                    dbProduct.get().setPrice(cleaningProduct.getPrice());
                }
                if (cleaningProduct.getQuantity() != 0) {
                    dbProduct.get().setQuantity(cleaningProduct.getQuantity());
                }
                if (cleaningProduct.getPhotography() != null) {
                    dbProduct.get().setPhotography(cleaningProduct.getPhotography());
                }
                dbProduct.get().setAvailability(cleaningProduct.isAvailability());

                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return cleaningProduct;
            }
        }else{
            return cleaningProduct;
        }
    }

    public boolean delete(int Id) {
        Boolean productBoolean = getProduct(Id).map(cleaningProduct ->{
            productRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
        return productBoolean;
    }
}
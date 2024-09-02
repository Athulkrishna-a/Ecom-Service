package com.mortal.SpringBootEcom.servicce;

import com.mortal.SpringBootEcom.model.Products;
import com.mortal.SpringBootEcom.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Products> getAllProduct() {
        return productRepo.findAll();
    }

    public Products getProductById(int id) {
        return productRepo.findById(id).orElse(new Products(-1));
    }



    public Products addProduct(Products product, MultipartFile image) throws IOException {

        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepo.save(product);

    }

    public Products updateProduct(Products product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepo.save(product);
    }


    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Products> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }
}

package com.mortal.SpringBootEcom.controller;


import com.mortal.SpringBootEcom.model.Products;
import com.mortal.SpringBootEcom.servicce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getProducts(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{id}")
    public  ResponseEntity<Products> getProductById(@PathVariable  int id){
        Products product= productService.getProductById(id);
        if(product.getId() > 0){
            return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
        }
        else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getProductImageById(@PathVariable int productId){
       Products product = productService.getProductById(productId);
        if(product.getId() > 0){
            return new ResponseEntity<>(product.getImageData(),HttpStatus.ACCEPTED);
        }
        else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Products product, @RequestPart MultipartFile imageFile){
        Products savedProduct = null;
        try {
            savedProduct = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Products product, @RequestPart MultipartFile imageFile){

        Products editProduct=null;
        try {
            editProduct = productService.updateProduct(product,imageFile);
            return new ResponseEntity<>("Updated" , HttpStatus.OK);
        }catch (IOException e){
            return  new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Products product=productService.getProductById(id);
        if(product != null){
            productService.deleteProduct(id);
            return new ResponseEntity<>("Deleted" ,HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Products>> searchProduct(@RequestParam String keyword){
        List<Products> products= productService.searchProducts(keyword);
        return  new ResponseEntity<>(products , HttpStatus.OK);
    }
}

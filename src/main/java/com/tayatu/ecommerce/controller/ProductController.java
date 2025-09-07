package com.tayatu.ecommerce.controller;

import com.tayatu.ecommerce.model.Product;
import com.tayatu.ecommerce.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id){
        Product product = productService.getProductById(id);

        if(product.getId()>0){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(
            @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile) {

        Product product1  = null;
        try {
            product1 = productService.addProduct(product, imageFile);
            return  new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (IOException e) {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable int productId) {
        Product product = productService.getProductById(productId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        if (product.getId() > 0) {
            return new ResponseEntity<>(product.getImageData(),headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProduct(
            @PathVariable int productId,
            @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile
    ){
        try {
            Product product1 = productService.updateProduct(productId, product, imageFile);
            return  new ResponseEntity<>(product1, HttpStatus.CREATED);
        }
        catch (RuntimeException e) { // custom exception
            return new ResponseEntity<>("Product not found with id: " + productId, HttpStatus.NOT_FOUND);
        } catch (IOException e) {

            System.out.println("HELLO WORLD");
            System.out.println(e);
            return new ResponseEntity<>("Product not found with id: " + productId, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/search")
    public  ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
        List<Product> products= productService.search(keyword);
        return  new ResponseEntity<>(products, HttpStatus.OK);
    }



}

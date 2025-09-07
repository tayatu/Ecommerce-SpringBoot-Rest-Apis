package com.tayatu.ecommerce.service;

import com.tayatu.ecommerce.model.Product;
import com.tayatu.ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;


    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(new Product(-1));
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageData(image.getBytes());
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        return repo.save(product);
    }

    public byte[] getProductImage(int productId) {

        return repo.findById(productId).orElse(new Product(-1)).getImageData();
    }

    public Product updateProduct(int productId, Product updatedProduct, MultipartFile imageFile) throws IOException {
        Product existingProduct = repo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        // Update fields only if provided
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setBrand(updatedProduct.getBrand());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setReleaseDate(updatedProduct.getReleaseDate());
        existingProduct.setStockQuantity(updatedProduct.getStockQuantity());
        existingProduct.setProductAvailable(updatedProduct.isProductAvailable());

        // Update image only if provided
        if (imageFile != null && !imageFile.isEmpty()) {
            existingProduct.setImageType(imageFile.getContentType());
            existingProduct.setImageData(imageFile.getBytes());
            existingProduct.setImageName(imageFile.getOriginalFilename());
        }

        // Save updated product
        return repo.save(existingProduct);
    }

    public void deleteProduct(int productId) {
        repo.deleteById(productId);
    }

    public List<Product> search(String keyword) {
        return  repo.searchProducts(keyword);

    }
}

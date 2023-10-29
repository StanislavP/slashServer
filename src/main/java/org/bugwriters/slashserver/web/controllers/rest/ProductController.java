package org.bugwriters.slashserver.web.controllers.rest;

import jakarta.validation.Valid;
import org.bugwriters.slashserver.models.entity.ProductEntity;
import org.bugwriters.slashserver.models.request.MyProductsRequest;
import org.bugwriters.slashserver.models.request.ProductRequest;
import org.bugwriters.slashserver.models.response.MessageResponse;
import org.bugwriters.slashserver.models.response.ProductResponse;
import org.bugwriters.slashserver.models.response.ProductsResponse;
import org.bugwriters.slashserver.repository.ProductRepository;
import org.bugwriters.slashserver.repository.ProductTypeRepository;
import org.bugwriters.slashserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@CrossOrigin(origins = "*", maxAge = 360000)
@RestController
@RequestMapping("/api/product")
public class ProductController {
    UserRepository userRepository;
    ProductRepository productRepository;
    ProductTypeRepository productTypeRepository;


    @Autowired
    public ProductController(UserRepository userRepository, ProductRepository productRepository,ProductTypeRepository productTypeRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }


    @PostMapping("/add")
    @PreAuthorize("hasRole('BUSINESS')")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductRequest productRequest) {

        if (productRepository.existsByName(productRequest.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Product name is already in use!"));
        }
        if (!userRepository.findByEmail(productRequest.getClientName()).isPresent()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Wrong user name!"));
        }
        var new_prod = new ProductEntity();
        new_prod.setName(productRequest.getName());
        new_prod.setDescription(productRequest.getDescription());
        new_prod.setDuration(productRequest.getDuration());
        new_prod.setDiscount(productRequest.getDiscount());
        new_prod.setPrice(productRequest.getPrice());
        new_prod.setCreatedDate(new Date());
        new_prod.setUser(userRepository.findByEmail(productRequest.getClientName()).get());
        new_prod.setProductType(productTypeRepository.findByProductType(productRequest.getProductType()).get());

        productRepository.saveAndFlush(new_prod);
        return ResponseEntity.ok(new MessageResponse("Product add successfully!"));
    }


    @PostMapping("/edit")
    @PreAuthorize("hasRole('BUSINESS')")
    public ResponseEntity<?> editProduct(@Valid @RequestBody ProductRequest productRequest) {

        if (!productRepository.existsById(productRequest.getId())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Product whit this name not exists!"));
        }

        var edit_product = productRepository.findById(productRequest.getId()).get();
        edit_product.setName(productRequest.getName());
        edit_product.setDescription(productRequest.getDescription());
        edit_product.setDuration(productRequest.getDuration());
        edit_product.setDiscount(productRequest.getDiscount());
        edit_product.setPrice(productRequest.getPrice());
        edit_product.setCreatedDate(new Date());
        edit_product.setProductType(productTypeRepository.findByProductType(productRequest.getProductType()).get());
        productRepository.saveAndFlush(edit_product);

        return ResponseEntity.ok(new MessageResponse("Product edit successfully!"));
    }


    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('BUSINESS')")
    public ResponseEntity<?> deleteProduct(@PathVariable  String id) {

        if (!productRepository.existsById(Long.parseLong(id))) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Product whit this id not exists!"));
        }

        var delete_prod = productRepository.findById(Long.parseLong(id)).get();

        productRepository.delete(delete_prod);
        return ResponseEntity.ok(new MessageResponse("Product delete successfully!"));
    }

    @GetMapping("")
    @PreAuthorize("hasRole('CLIENT') or hasRole('BUSINESS')")
    public ResponseEntity<?> getAllProducts( ) {

       var products = productRepository.findAll();
        var response_products =  new ArrayList<ProductResponse>();
        products.forEach(
            productEntity -> {
                response_products.add(new ProductResponse()
                                .setId(productEntity.getId())
                        .setName(productEntity.getName())
                        .setPrice(productEntity.getPrice())
                        .setDescription(productEntity.getDescription())
                        .setDuration(productEntity.getDuration())
                        .setDiscount(productEntity.getDiscount())
                        .setType(productEntity.getProductType().getProductType().name())
                        .setOwnerName(productEntity.getUser().getName()));
            }
        );

       var products_final = new ProductsResponse();
        products_final.setProductsResponse(response_products);
        return ResponseEntity.ok(products_final);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('CLIENT') or hasRole('BUSINESS')")
    public ResponseEntity<?> getProduct( @PathVariable String id) {

        if (!productRepository.existsById(Long.parseLong(id))) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Product whit this name not exists!"));
        }

        var products = productRepository.findById(Long.parseLong(id)).get();

        var response_product = new ProductResponse()
                .setId(products.getId())
                .setName(products.getName())
                .setPrice(products.getPrice())
                .setDescription(products.getDescription())
                .setDuration(products.getDuration())
                .setDiscount(products.getDiscount())
                .setType(products.getProductType().getProductType().name())
                .setOwnerName(products.getUser().getName());

        return ResponseEntity.ok(response_product);
    }

    @PostMapping("/mine")
    @PreAuthorize("hasRole('CLIENT') or hasRole('BUSINESS')")
    public ResponseEntity<?> getProducts(@Valid @RequestBody MyProductsRequest myProductsRequest ) {
        if (!userRepository.findByEmail(myProductsRequest.getName()).isPresent()) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Wrong user name!"));
        }


        var products = productRepository.findAllByUser_Email(myProductsRequest.getName());
        var response_products =  new ArrayList<ProductResponse>();
        products.forEach(
                productEntity -> {
                    response_products.add(new ProductResponse()
                            .setId(productEntity.getId())
                            .setName(productEntity.getName())
                            .setPrice(productEntity.getPrice())
                            .setDescription(productEntity.getDescription())
                            .setDuration(productEntity.getDuration())
                            .setDiscount(productEntity.getDiscount())
                            .setType(productEntity.getProductType().getProductType().name())
                            .setOwnerName(productEntity.getUser().getName()));
                }
        );

        var products_final = new ProductsResponse();
        products_final.setProductsResponse(response_products);
        return ResponseEntity.ok(products_final);
    }



}

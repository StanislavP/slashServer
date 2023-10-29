package org.bugwriters.slashserver.web.controllers.rest;

import jakarta.validation.Valid;
import org.bugwriters.slashserver.models.entity.ProductEntity;
import org.bugwriters.slashserver.models.entity.SellEntity;
import org.bugwriters.slashserver.models.request.ProductRequest;
import org.bugwriters.slashserver.models.request.SellRequest;
import org.bugwriters.slashserver.models.response.MessageResponse;
import org.bugwriters.slashserver.repository.ProductRepository;
import org.bugwriters.slashserver.repository.ProductTypeRepository;
import org.bugwriters.slashserver.repository.SellRepository;
import org.bugwriters.slashserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/sell")
public class SellController {
    UserRepository userRepository;
    ProductRepository productRepository;
    ProductTypeRepository productTypeRepository;
    SellRepository sellRepository;


    @Autowired
    public SellController(UserRepository userRepository, ProductRepository productRepository,ProductTypeRepository productTypeRepository,SellRepository sellRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.sellRepository = sellRepository;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('BUSINESS')")
    public ResponseEntity<?> sellProduct(@Valid @RequestBody SellRequest sellRequest) {

        sellRequest.getSellProductsList().forEach(
                sellProducts -> {

                    if (productRepository.existsByName(sellProducts.getProductName())  ) {

                    var product = productRepository.findByName(sellProducts.getProductName());
                    var sell  = new SellEntity();
                    sell.setPrice(sellProducts.getPrice());
                    sell.setQuantity(sellProducts.getQuantity());
                    sell.setProduct(product);
                    sellRepository.saveAndFlush(sell);
                    productRepository.saveAndFlush(product);

                    }
                }

        );

        return ResponseEntity.ok(new MessageResponse("Product add successfully!"));
    }
}

package org.bugwriters.slashserver.web.controllers.rest;

import jakarta.validation.Valid;
import org.bugwriters.slashserver.models.entity.ProductEntity;
import org.bugwriters.slashserver.models.request.ProductRequest;
import org.bugwriters.slashserver.models.request.SellRequest;
import org.bugwriters.slashserver.models.response.MessageResponse;
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

//    @PostMapping("")
//    @PreAuthorize("hasRole('BUSINESS')")
//    public ResponseEntity<?> sellProduct(@Valid @RequestBody SellRequest sellRequest) {
//
//        if (productRepository.existsByName(productRequest.getName())) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Product name is already in use!"));
//        }
//        if (!userRepository.findByEmail(productRequest.getClientName()).isPresent()) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Wrong user name!"));
//        }
//        var new_prod = new ProductEntity();
//        new_prod.setName(productRequest.getName());
//        new_prod.setDescription(productRequest.getDescription());
//        new_prod.setDuration(productRequest.getDuration());
//        new_prod.setDiscount(productRequest.getDiscount());
//        new_prod.setPrice(productRequest.getPrice());
//        new_prod.setCreatedDate(new Date());
//        new_prod.setUser(userRepository.findByEmail(productRequest.getClientName()).get());
//        new_prod.setProductType(productTypeRepository.findByProductType(productRequest.getProductType()).get());
//
//        productRepository.saveAndFlush(new_prod);
//        return ResponseEntity.ok(new MessageResponse("Product add successfully!"));
//    }
}

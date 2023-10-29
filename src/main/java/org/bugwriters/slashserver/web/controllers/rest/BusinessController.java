package org.bugwriters.slashserver.web.controllers.rest;

import jakarta.validation.Valid;
import org.bugwriters.slashserver.enums.UserRoles;
import org.bugwriters.slashserver.models.request.MyProductsRequest;
import org.bugwriters.slashserver.models.response.*;
import org.bugwriters.slashserver.repository.ProductRepository;
import org.bugwriters.slashserver.repository.ProductTypeRepository;
import org.bugwriters.slashserver.repository.RoleRepository;
import org.bugwriters.slashserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

@RestController
@RequestMapping("/api/business")
public class BusinessController {
    UserRepository userRepository;
    RoleRepository roleRepository;
    ProductRepository productRepository;

    @Autowired
    public BusinessController(UserRepository userRepository,RoleRepository roleRepository,ProductRepository productRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('CLIENT') or hasRole('BUSINESS')")
    public ResponseEntity<?> getAllBusinessNames( ) {

        var users = userRepository.findAll();
//        var products = productRepository.findAll();
        var response_clients =  new ArrayList<BusinessResponse>();
        users.forEach(
                userEntity -> {
                    userEntity.getRoles().forEach(roleEntity -> {
                                if (roleEntity.getUserRole() == UserRoles.ROLE_BUSINESS) {

                                    response_clients.add(new BusinessResponse().setId(userEntity.getId()).setName(userEntity.getName()));
                                }
                            }
                    );
                }
        );
        var clients = new UsersBusinessResponse();
        clients.setClients(response_clients);
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('CLIENT') or hasRole('BUSINESS')")
    public ResponseEntity<?> getProducts( @PathVariable String id ) {
        if (!userRepository.findById(Long.parseLong(id)).isPresent()) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Wrong user name!"));
            return ResponseEntity.ok(new ProductsResponse().setProductsResponse(new ArrayList<ProductResponse>()));
        }

//        var products = productRepository.findAllByUser_Name(myProductsRequest.getName());
//
//        var products_final = new ProductsResponse();
//        products_final.setProductsResponse(products);
//
        var user = userRepository.findById(Long.parseLong(id)).get();

        var products = productRepository.findAllByUser_Email(user.getEmail());
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

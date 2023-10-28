package org.bugwriters.slashserver.web.controllers.rest;

import org.bugwriters.slashserver.enums.UserRoles;
import org.bugwriters.slashserver.models.response.ProductResponse;
import org.bugwriters.slashserver.models.response.UsersBusinessResponse;
import org.bugwriters.slashserver.repository.ProductRepository;
import org.bugwriters.slashserver.repository.ProductTypeRepository;
import org.bugwriters.slashserver.repository.RoleRepository;
import org.bugwriters.slashserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

@RestController
@RequestMapping("/api/business")
public class BusinessController {
    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    public BusinessController(UserRepository userRepository,RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('CLIENT') or hasRole('BUSINESS')")
    public ResponseEntity<?> getAllBusinessNames( ) {

        var users = userRepository.findAll();
//        var products = productRepository.findAll();
        var response_clients =  new ArrayList<String>();
        users.forEach(
                userEntity -> {
                    userEntity.getRoles().forEach(roleEntity -> {
                                if (roleEntity.getUserRole() == UserRoles.ROLE_BUSINESS) {
                                    response_clients.add(userEntity.getName());
                                }
                            }
                    );
                }
        );
        var clients = new UsersBusinessResponse();
        clients.setClients(response_clients);
        return ResponseEntity.ok(clients);
    }
}

package org.bugwriters.slashserver.services;

import jakarta.annotation.PostConstruct;
import org.bugwriters.slashserver.enums.ProductType;
import org.bugwriters.slashserver.enums.UserRoles;
import org.bugwriters.slashserver.models.entity.ProductTypeEntity;
import org.bugwriters.slashserver.models.entity.RoleEntity;
import org.bugwriters.slashserver.repository.ProductTypeRepository;
import org.bugwriters.slashserver.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {

    private final RoleRepository roleRepository;
    private final ProductTypeRepository productTypeRepository;

    @Autowired
    public InitService(RoleRepository roleRepository, ProductTypeRepository productTypeRepository) {
        this.roleRepository = roleRepository;
        this.productTypeRepository = productTypeRepository;
    }

    @PostConstruct
    private void initBase() {
        initRoles();
        initProductTypes();
    }

    private void initRoles() {
        if (roleRepository.count() == 0) {
            var userRole = new RoleEntity().setUserRole(UserRoles.ROLE_CLIENT);
            var businessRole = new RoleEntity().setUserRole(UserRoles.ROLE_BUSINESS);
            roleRepository.save(userRole);
            roleRepository.save(businessRole);
        }
    }

    private void initProductTypes() {
        if (productTypeRepository.count() == 0) {
            var service = new ProductTypeEntity().setProductType(ProductType.SERVICE);
            var product = new ProductTypeEntity().setProductType(ProductType.PRODUCT);

            productTypeRepository.save(service);
            productTypeRepository.save(product);
        }
    }

}

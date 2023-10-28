package org.bugwriters.slashserver.models.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column
    private String name; //–  first name of the user.

    @Column(name = "password")
    private String password;

    @Column(unique = true,nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<RoleEntity> roles = new HashSet<>();

    public UserEntity() {
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}

package org.bugwriters.slashserver.models.dto;

import org.bugwriters.slashserver.models.entity.RoleEntity;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;

    private String password;

    private String email;

    private Set<RoleEntity> roles = new HashSet<>();

    public User() {
    }

    public User(String name, String password, String email, Set<RoleEntity> roles) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public User setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}

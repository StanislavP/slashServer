package org.bugwriters.slashserver.models.response;

public class BusinessResponse {

    Long id;
    String name;

    public BusinessResponse() {
    }

    public Long getId() {
        return id;
    }

    public BusinessResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BusinessResponse setName(String name) {
        this.name = name;
        return this;
    }
}

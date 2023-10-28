package org.bugwriters.slashserver.models.request;

public class MyProductsRequest {

    String name;

    public MyProductsRequest() {
    }

    public String getName() {
        return name;
    }

    public MyProductsRequest setName(String name) {
        this.name = name;
        return this;
    }
}

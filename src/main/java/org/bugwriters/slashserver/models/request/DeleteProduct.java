package org.bugwriters.slashserver.models.request;

public class DeleteProduct {
    String name;

    public DeleteProduct() {
    }

    public String getName() {
        return name;
    }

    public DeleteProduct setName(String name) {
        this.name = name;
        return this;
    }
}

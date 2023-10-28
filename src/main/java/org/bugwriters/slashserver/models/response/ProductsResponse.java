package org.bugwriters.slashserver.models.response;

import java.util.List;

public class ProductsResponse {

    private List<ProductResponse> productsResponse;

    public ProductsResponse() {
    }

    public List<ProductResponse> getProductsResponse() {
        return productsResponse;
    }

    public ProductsResponse setProductsResponse(List<ProductResponse> productsResponse) {
        this.productsResponse = productsResponse;
        return this;
    }
}

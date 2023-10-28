package org.bugwriters.slashserver.models.request;

import java.util.List;

public class SellRequest {
    List<SellProducts> sellProductsList;

    public SellRequest(List<SellProducts> sellProductsList) {
        this.sellProductsList = sellProductsList;
    }

    public List<SellProducts> getSellProductsList() {
        return sellProductsList;
    }

    public SellRequest setSellProductsList(List<SellProducts> sellProductsList) {
        this.sellProductsList = sellProductsList;
        return this;
    }
}

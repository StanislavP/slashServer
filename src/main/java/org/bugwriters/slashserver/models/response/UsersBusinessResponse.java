package org.bugwriters.slashserver.models.response;

import java.util.List;

public class UsersBusinessResponse {

    List<BusinessResponse> clients;

    public UsersBusinessResponse() {
    }

    public List<BusinessResponse> getClients() {
        return clients;
    }

    public UsersBusinessResponse setClients(List<BusinessResponse> clients) {
        this.clients = clients;
        return this;
    }
}

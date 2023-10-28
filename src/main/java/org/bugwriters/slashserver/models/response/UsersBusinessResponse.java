package org.bugwriters.slashserver.models.response;

import java.util.List;

public class UsersBusinessResponse {

    List<String> clients;

    public UsersBusinessResponse() {
    }

    public List<String> getClients() {
        return clients;
    }

    public UsersBusinessResponse setClients(List<String> clients) {
        this.clients = clients;
        return this;
    }
}

package com.clientsapi.usecases;

import com.clientsapi.entities.Client;
import com.clientsapi.common_services.services.CommonService;
import java.util.Optional;

public interface ClientService extends CommonService<Client> {

    Optional findById(Integer id);

    Iterable<Client> findAll();

    Client save(Client client);

    boolean delete(Integer id);

}

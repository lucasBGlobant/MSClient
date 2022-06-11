package com.clientsapi.persistence_component.repository;

import com.clientsapi.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findById(Integer id);

    List<Client> findAll();


    Client save(Client client);

    void delete(Client client);

}

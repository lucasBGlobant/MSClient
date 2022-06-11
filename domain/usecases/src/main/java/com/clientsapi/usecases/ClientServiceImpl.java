package com.clientsapi.usecases;

import com.clientsapi.common_services.services.CommonServiceImpl;
import com.clientsapi.entities.Client;
import com.clientsapi.persistence_component.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl extends CommonServiceImpl<Client, ClientRepository> implements ClientService  {

    @Override
    @Transactional
    public Optional<Client> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        if(findById(id).isPresent()) {
            repository.delete(repository.findById(id).get());
            return true;
        } else{
            return false;
        }

    }
}

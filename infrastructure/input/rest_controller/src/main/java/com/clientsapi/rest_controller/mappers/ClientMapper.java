package com.clientsapi.rest_controller.mappers;

import com.clientsapi.entities.Client;

import com.clientsapi.rest_controller.models.ClientResponse;
import com.clientsapi.rest_controller.models.ClientRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client clientRequestToEntity(ClientRequest clientRequest);

    ClientResponse clientToClientResponse(Client client);
}

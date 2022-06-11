package com.clientsapi.rest_controller.controllers;

import com.clientsapi.entities.Client;
import com.clientsapi.rest_controller.mappers.ClientMapper;
import com.clientsapi.rest_controller.models.ClientResponse;
import com.clientsapi.rest_controller.models.ClientRequest;
import com.clientsapi.usecases.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class CreateClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientMapper clientMapper;

    @ApiOperation(value = "Register a client in the database")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Client created successful"),
            @ApiResponse(responseCode = "227", description = "Client already exist"),
            @ApiResponse(responseCode = "500", description = "Internal error"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody @Valid ClientRequest clientRequest) throws NoSuchAlgorithmException {

        Client client = clientService.save(clientMapper.clientRequestToEntity(clientRequest));

        return new ResponseEntity(clientMapper.clientToClientResponse(client).getClientId(), HttpStatus.CREATED);

    }

}

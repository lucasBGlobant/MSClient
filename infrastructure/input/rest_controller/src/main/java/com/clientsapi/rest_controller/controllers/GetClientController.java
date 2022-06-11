package com.clientsapi.rest_controller.controllers;

import com.clientsapi.entities.Client;
import com.clientsapi.rest_controller.mappers.ClientMapper;
import com.clientsapi.rest_controller.models.ClientResponse;
import com.clientsapi.usecases.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class GetClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;


    @GetMapping("/{id}")
    @Operation(summary = "Get a client by eventId")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Client doesn't exist")
    })
    public ResponseEntity<ClientResponse> retrieveClient(@PathVariable Integer id){

        Optional<Client> client = clientService.findById(id);
        return ResponseEntity.of(client.map(clientMapper::clientToClientResponse));
    }




}

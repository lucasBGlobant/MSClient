package com.clientsapi.rest_controller.controllers;

import com.clientsapi.rest_controller.mappers.ClientMapper;
import com.clientsapi.rest_controller.models.ClientResponse;
import com.clientsapi.usecases.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class DeleteClientController {

    @Autowired
    private ClientService clientService;

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client deleted"),
            @ApiResponse(responseCode = "230", description = "Client not deleted")
    })
    public ResponseEntity<ClientResponse> deleteClient(@PathVariable Integer id){

        if(clientService.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}

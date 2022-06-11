package com.clientsapi.rest_controller.controllers;

import com.clientsapi.usecases.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class GetAllClientsController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    @Operation(summary = "Get all clients")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(clientService.findAll());
    }
}

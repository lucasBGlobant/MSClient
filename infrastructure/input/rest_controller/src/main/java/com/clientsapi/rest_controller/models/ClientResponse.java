package com.clientsapi.rest_controller.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ClientResponse {

    @Schema(description = "Response code", example = "200", required = true)
    Integer responseCode;

    @Schema(description = "Response message", example = "OK", required = true)
    String responseMessage;

    @Schema(description = "Message identifier", example = "2d09257a-cc8e-46e3-9a28-29c76dec4027", required = true)
    String messageId;

    @Schema(description = "Message of Operation result", example = "Success", required = true)
    String operationResult;

    @Schema(description = "Client id", example = "1", required = true)
    Integer clientId;
    @Schema(description = "Client name", example = "Jhon", required = true)
    String name;

    @Schema(description = "Client last name", example = "Doe", required = true)
    String lastName;

    @Schema(description = "Business name", example = "Company Inc", required = true)
    String businessName;

    @Schema(description = "Company identifier", example = "1", required = true)
    Integer companyId;

    @Schema(description = "Client email", example = "jhon_doe@email.com", required = true)
    String email;

    @Schema(description = "Client address", example = "Doral Floridad Queens R", required = true)
    String address;

    @Schema(description = "Client phone", example = "+1 201 000 0000", required = true)
    String phone;


    public ClientResponse(Integer responseCode, String responseMessage, String messageId,
                          String operationResult, String name, String lastName, String businessName,
                          Integer companyId, String email, String address, String phone) {

        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.messageId = messageId;
        this.operationResult = operationResult;
        this.name = name;
        this.lastName = lastName;
        this.businessName = businessName;
        this.companyId = companyId;
        this.email = email;
        this.address = address;
        this.phone = phone;

    }

}

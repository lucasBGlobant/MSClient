package com.clientsapi.rest_controller.models;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;


@Getter
@Setter
public class ClientRequest {

    @Size(min = 1, max = 30)
    @Parameter(description = "Client identifier")
    @Schema(example = "1", required = true)
    private Integer clientId;

    @Size(min = 1, max = 30)
    @Parameter(description = "Client name")
    @Schema(example = "Jhon", required = true)
    private String name;

    @Size(min = 1, max = 30)
    @Parameter(description = "Client lastname")
    @Schema(example = "Doe", required = true)
    private String lastName;

    @Size(min = 1, max = 30)
    @Parameter(description = "Business name")
    @Schema(example = "Company Inc", required = true)
    private String businessName;

    @Size(min = 1, max = 30)
    @Parameter(description = "Company identifier")
    @Schema(example = "1", required = true)
    private Integer companyId;

    @Size(min = 6, max = 30)
    @Parameter(description = "Client email")
    @Schema(example = "jhon_doe@email.com", required = true)
    private String email;

    @Size(min = 1, max = 30)
    @Parameter(description = "Client address")
    @Schema(example = "Doral Floridad Queens R", required = true)
    private String address;

    @Size(min = 1, max = 30)
    @Parameter(description = "Client phone")
    @Schema(example = "+1 201 000 0000", required = true)
    private String phone;

}

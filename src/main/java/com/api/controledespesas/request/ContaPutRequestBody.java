package com.api.controledespesas.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Builder
@Data
public class ContaPutRequestBody {

    private Long id;
    @NotEmpty (message = "This attribute can´t be empty")
    private String nome;
    @NotEmpty (message = "This attribute can´t be empty")
    private String tipoConta;
    @NotEmpty (message = "This attribute can´t be empty")
    private String agencia;
}

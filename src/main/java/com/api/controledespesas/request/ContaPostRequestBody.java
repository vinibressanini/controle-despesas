package com.api.controledespesas.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Builder
@Data
public class ContaPostRequestBody {

    @NotEmpty(message = "This attribute can not be empty")
    private String nome;
    @NotNull(message = "This attribute can not be empty")
    private double saldo;
    @NotEmpty(message = "This attribute can not be empty")
    private String tipoConta;
    @NotEmpty(message = "This attribute can not be empty")
    private String agencia;


}

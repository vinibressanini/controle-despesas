package com.api.controledespesas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "This attribute can´t be empty ")
    private String nome;
    @NotEmpty (message = "This attribute can´t be empty ")
    private double saldo;
    @NotEmpty (message = "This attribute can´t be empty ")
    private String tipoConta;
    @NotEmpty (message = "This attribute can´t be empty ")
    private String agencia;

}
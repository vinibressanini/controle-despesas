package com.api.controledespesas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "This attribute can´t be empty ")
    private String tipo;

    @NotEmpty (message = "This attribute can´t be empty ")
    private String data;

    @NotEmpty (message = "This attribute can´t be empty ")
    private double valor;

    @ManyToOne
    @NotEmpty (message = "This attribute can´t be empty ")
    private Conta conta;

}

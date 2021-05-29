package com.contasapi.contas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private double valor;

    private boolean paga;

    public Conta(String nome, double valor, boolean paga) {
        this.nome = nome;
        this.valor = valor;
        this.paga = paga;
    }
}

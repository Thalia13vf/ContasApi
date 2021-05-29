package com.contasapi.contas.builder;

import com.contasapi.contas.request.ContaPostRequestBody;

public class ContaDTOBuilder {
    private String nome = "Agua";

    private double valor = 90.99;

    private boolean paga = false;

    public ContaDTOBuilder(){

    }
    public ContaDTOBuilder(String nome, double valor, boolean paga){
        this.nome = nome;
        this.valor = valor;
        this.paga = paga;
    }

    public ContaPostRequestBody toContaPostRequestBody(){
        return new ContaPostRequestBody();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

}

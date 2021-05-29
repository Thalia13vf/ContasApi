package com.contasapi.contas.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaPostRequestBody {
    @NotNull(message = "O nome não pode ser nulo!")
    @NotEmpty(message = "O nome não pode ser vazio!")
    private String nome;
    
    @NotNull(message = "O valor não pode ser nulo!")
    private double valor;

    @NotNull(message = "O campo paga não pode ser nulo!")
    private boolean paga;

}

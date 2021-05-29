package com.contasapi.contas.service;

import com.contasapi.contas.builder.ContaDTOBuilder;
import com.contasapi.contas.exception.BadRequestException;
import com.contasapi.contas.model.Conta;
import com.contasapi.contas.repository.ContaRepository;
import com.contasapi.contas.request.ContaPostRequestBody;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ContaServiceTest {

    private static final long  INVALID_CONTA_ID = 1L;

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private ContaService contaService;

    @Test
    public void whenAValidIdIsInformedThenShouldReturnAConta(){
        ContaPostRequestBody contaPostRequestBody = new ContaPostRequestBody("Conta de internet", 100.5, false);
        Conta contaEsperada = new Conta(1, contaPostRequestBody.getNome(), contaPostRequestBody.getValor(), contaPostRequestBody.isPaga());

        Mockito.when(contaRepository.findById(contaEsperada.getId())).thenReturn(Optional.of(contaEsperada));

        Conta contaEncontrada = contaService.findById(contaEsperada.getId());

        Assert.assertEquals(contaEsperada.getId(), contaEncontrada.getId());
        Assert.assertEquals(contaEncontrada.getNome(), contaEncontrada.getNome());
        Assert.assertEquals(contaEncontrada.isPaga(), contaEsperada.isPaga());
    }

    @Test
    public void whenAInvalidIdIsInformedThrowException(){
        ContaPostRequestBody contaPostRequestBody = new ContaPostRequestBody("Conta de internet", 100.5, false);
        Conta contaComIdInvalido = new Conta(-1, contaPostRequestBody.getNome(), contaPostRequestBody.getValor(), contaPostRequestBody.isPaga());

        Mockito.when(contaRepository.findById(contaComIdInvalido.getId())).thenReturn(Optional.empty());

        assertThrows(BadRequestException.class, () -> contaService.findById(contaComIdInvalido.getId()));

    }

    @Test
    public void whenContaInformedThenItShouldBeCreated(){ //quando uma conta for informada deve ser criada com sucesso
        ContaPostRequestBody contaPostRequestBody = new ContaPostRequestBody("Conta de internet", 100.5, false);

        Conta contaSalva = new Conta(contaPostRequestBody.getNome(),
                contaPostRequestBody.getValor(),
                contaPostRequestBody.isPaga());

        Mockito.when(contaRepository.save(contaSalva)).thenReturn(contaSalva);

        Conta contaCriada = contaService.save(contaPostRequestBody);

        assertEquals(contaSalva.getId(), contaCriada.getId());
        assertEquals(contaSalva.getNome(), contaCriada.getNome());

    }

}

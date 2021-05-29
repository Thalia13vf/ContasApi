package com.contasapi.contas.service;

import com.contasapi.contas.exception.BadRequestException;
import com.contasapi.contas.model.Conta;
import com.contasapi.contas.repository.ContaRepository;
import com.contasapi.contas.request.ContaPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> findAll(){
        return contaRepository.findAll();
    }

    public Conta findById(Long id){
        return contaRepository.findById(id).orElseThrow(() ->
                new BadRequestException("Conta não encontrada!"));
    }

    public Conta save(ContaPostRequestBody contaPostRequestBody){
        Conta conta = new Conta(contaPostRequestBody.getNome(), contaPostRequestBody.getValor(),
                contaPostRequestBody.isPaga());

        return contaRepository.save(conta);
    }

    public void delete(long id){
        contaRepository.delete(findById(id));
    }

    public Conta replace (Conta conta){
        Conta updateConta = findById(conta.getId());
        updateConta.setNome(conta.getNome());
        updateConta.setValor(conta.getValor());
        updateConta.setPaga(conta.isPaga());

        return contaRepository.save(updateConta);
    }
}

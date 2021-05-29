package com.contasapi.contas.controller;

import com.contasapi.contas.model.Conta;
import com.contasapi.contas.request.ContaPostRequestBody;
import com.contasapi.contas.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("contas")
public class ContaController {
    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> getAll(){
        return ResponseEntity.ok(contaService.findAll());
    }

    @GetMapping("/{id}")
    public Conta getContaById(@PathVariable long id){
        return contaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Conta> create(@RequestBody @Valid ContaPostRequestBody contaPostRequestBody){
        return new ResponseEntity<>(contaService.save(contaPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Conta> update(@RequestBody Conta conta){
        return new ResponseEntity<>(contaService.replace(conta), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        contaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

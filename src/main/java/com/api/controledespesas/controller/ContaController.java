package com.api.controledespesas.controller;

import com.api.controledespesas.domain.Conta;
import com.api.controledespesas.request.ContaPostRequestBody;
import com.api.controledespesas.request.ContaPutRequestBody;
import com.api.controledespesas.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Conta>> listAll(){

        return ResponseEntity.ok(contaService.listAll());

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Conta> findbyId(@PathVariable long id) {
        return ResponseEntity.ok(contaService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Conta> save(@RequestBody @Valid ContaPostRequestBody contaPostRequestBody) {
        return new ResponseEntity<>(contaService.save(contaPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        contaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/replace")
    public ResponseEntity<Conta> replace (@RequestBody @Valid ContaPutRequestBody contaPutRequestBody) {
        contaService.replace(contaPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

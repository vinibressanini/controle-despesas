package com.api.controledespesas.service;

import com.api.controledespesas.domain.Conta;
import com.api.controledespesas.exception.BadRequestException;
import com.api.controledespesas.mapper.ContaMapper;
import com.api.controledespesas.repository.ContaRepository;
import com.api.controledespesas.request.ContaPostRequestBody;
import com.api.controledespesas.request.ContaPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    public List<Conta> listAll () {
        return contaRepository.findAll();
    }

    public Conta findByIdOrThrowBadRequestException(long id) {
        return  contaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Account not found"));
    }


    @Transactional
    public Conta save (ContaPostRequestBody contaPostRequestBody) {

        return contaRepository.save(ContaMapper.INSTANCE.toConta(contaPostRequestBody) );

    }

    public void delete (long id) {

        contaRepository.delete(findByIdOrThrowBadRequestException(id));

    }

    public void replace (ContaPutRequestBody contaPutRequestBody) {

        Conta savedConta = findByIdOrThrowBadRequestException(contaPutRequestBody.getId());
        Conta conta =  ContaMapper.INSTANCE.toConta(contaPutRequestBody);
        conta.setId(savedConta.getId());
        conta.setSaldo(savedConta.getSaldo());
        contaRepository.save(conta);

    }

}

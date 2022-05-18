package com.api.controledespesas.service;

import com.api.controledespesas.domain.Conta;
import com.api.controledespesas.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    public List<Conta> listAllNonPageable () {
        return contaRepository.findAll();
    }

    public Conta findByIdOrThrowBadRequestException(long id) {
        return  contaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime Not Found"));
    }


    @Transactional
    public Conta save (ContaPostRequestBody contaPostRequestBody) {

        return contaRepository.save(ContaMapper.INSTANCE.toConta(contaRepository) );

    }

    public void delete (long id) {

        contaRepository.delete(findByIdOrThrowBadRequestException(id));

    }

    public void replace (ContaPutRequestBody contaPutRequestBody) {

        savedConta = findByIdOrThrowBadRequestException(contaPutRequestBody.getId());
        Conta conta =  ContaMapper.INSTANCE.toCont(contaPutRequestBody);
        conta.setId(savedConta.getId());
        contaRepository.save(conta);

    }

}

package com.api.controledespesas.mapper;

import com.api.controledespesas.domain.Conta;
import com.api.controledespesas.request.ContaPostRequestBody;
import com.api.controledespesas.request.ContaPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ContaMapper {

    public static final ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);

    public abstract Conta toConta(ContaPostRequestBody contaPostRequestBody);

    public abstract Conta toConta(ContaPutRequestBody contaPutRequestBody);
}

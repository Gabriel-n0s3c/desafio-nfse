package com.desafio.nfse_api.feature.credito.mapper;

import com.desafio.nfse_api.feature.credito.dto.CreditoResponseDTO;
import com.desafio.nfse_api.feature.credito.entity.Credito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CreditoMapper {

    @Mapping(source = "simplesNacional", target = "simplesNacional", qualifiedByName = "booleanToString")
    CreditoResponseDTO toDto(Credito credito);

    @Named("booleanToString")
    default String booleanToString(boolean simplesNacional) {
        return simplesNacional ? "Sim" : "Não";
    }
}
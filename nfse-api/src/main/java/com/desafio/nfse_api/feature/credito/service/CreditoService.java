package com.desafio.nfse_api.feature.credito.service;
import com.desafio.nfse_api.feature.credito.dto.CreditoResponseDTO;
import com.desafio.nfse_api.feature.credito.entity.Credito;
import com.desafio.nfse_api.feature.credito.mapper.CreditoMapper;
import com.desafio.nfse_api.feature.credito.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditoService {

    @Autowired
    private CreditoMapper creditoMapper;

    @Autowired
    private CreditoRepository creditoRepository;

    public List<CreditoResponseDTO> listarCreditosByNfse(String numeroNfse) {
        List<Credito> creditos = creditoRepository.findAllByNumeroNfse(numeroNfse);
        return creditos.stream()
                .map(creditoMapper::toDto)
                .collect(Collectors.toList());
    }

    public CreditoResponseDTO detalharCredito(String numeroCredito) {
        return creditoRepository.findByNumeroCredito(numeroCredito).map(creditoMapper::toDto).orElse(null);
    }
}



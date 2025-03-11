package com.desafio.nfse_api.feature.credito.service;

import com.desafio.nfse_api.feature.credito.dto.CreditoResponseDTO;
import com.desafio.nfse_api.feature.credito.entity.Credito;
import com.desafio.nfse_api.feature.credito.mapper.CreditoMapper;
import com.desafio.nfse_api.feature.credito.repository.CreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreditoServiceTest {

    @Mock
    private CreditoMapper creditoMapper;

    @Mock
    private CreditoRepository creditoRepository;

    @InjectMocks
    private CreditoService creditoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarCreditosByNfseTest() {
        Credito credito = new Credito();
        credito.setNumeroCredito("12345");
        credito.setNumeroNfse("54321");
        credito.setValorIssqn(BigDecimal.valueOf(100.00));
        credito.setDataConstituicao(LocalDate.now());

        when(creditoRepository.findAllByNumeroNfse("54321")).thenReturn(Collections.singletonList(credito));

        CreditoResponseDTO creditoResponseDTO = new CreditoResponseDTO();
        creditoResponseDTO.setNumeroCredito("12345");
        when(creditoMapper.toDto(credito)).thenReturn(creditoResponseDTO);

        List<CreditoResponseDTO> creditos = creditoService.listarCreditosByNfse("54321");

        assertNotNull(creditos);
        assertFalse(creditos.isEmpty());
        assertEquals("12345", creditos.get(0).getNumeroCredito());

        verify(creditoRepository, times(1)).findAllByNumeroNfse("54321");
        verify(creditoMapper, times(1)).toDto(credito);
    }

    @Test
    void detalharCreditoTest() {
        Credito credito = new Credito();
        credito.setNumeroCredito("12345");
        credito.setNumeroNfse("54321");
        credito.setValorIssqn(BigDecimal.valueOf(100.00));
        credito.setDataConstituicao(LocalDate.now());

        when(creditoRepository.findByNumeroCredito("12345")).thenReturn(Optional.of(credito));

        CreditoResponseDTO creditoResponseDTO = new CreditoResponseDTO();
        creditoResponseDTO.setNumeroCredito("12345");
        when(creditoMapper.toDto(credito)).thenReturn(creditoResponseDTO);

        CreditoResponseDTO response = creditoService.detalharCredito("12345");

        assertNotNull(response);
        assertEquals("12345", response.getNumeroCredito());

        verify(creditoRepository, times(1)).findByNumeroCredito("12345");
        verify(creditoMapper, times(1)).toDto(credito);
    }

    @Test
    void detalharCreditoCreditoNaoEncontradoTest() {
        when(creditoRepository.findByNumeroCredito("67890")).thenReturn(Optional.empty());

        CreditoResponseDTO response = creditoService.detalharCredito("67890");

        assertNull(response);

        verify(creditoRepository, times(1)).findByNumeroCredito("67890");
        verify(creditoMapper, never()).toDto(any(Credito.class));
    }
}

package com.desafio.nfse_api.feature.credito.controller;

import com.desafio.nfse_api.feature.credito.dto.CreditoResponseDTO;
import com.desafio.nfse_api.feature.credito.service.CreditoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreditoControllerTest {

    @Mock
    private CreditoService creditoService;

    @InjectMocks
    private CreditoController creditoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarCreditosByNfse_DeveRetornarListaDeCreditos() {
        String numeroNfse = "12345";
        List<CreditoResponseDTO> mockCreditos = List.of(
                new CreditoResponseDTO(
                        "CRED-001", numeroNfse, LocalDate.now(),
                        BigDecimal.TEN, "Tipo1", "true",
                        BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN
                ));

        when(creditoService.listarCreditosByNfse(numeroNfse)).thenReturn(mockCreditos);

        ResponseEntity<List<CreditoResponseDTO>> response = creditoController.listarCreditosByNfse(numeroNfse);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(mockCreditos, response.getBody());
        verify(creditoService, times(1)).listarCreditosByNfse(numeroNfse);
    }

    @Test
    void detalharCredito_DeveRetornarCreditoEspecifico() {
        String numeroCredito = "CRED-001";
        CreditoResponseDTO mockCredito = new CreditoResponseDTO(
                numeroCredito, "12345", LocalDate.now(),
                BigDecimal.TEN, "Tipo1", "true",
                BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN
        );

        when(creditoService.detalharCredito(numeroCredito)).thenReturn(mockCredito);

        ResponseEntity<CreditoResponseDTO> response = creditoController.detalharCredito(numeroCredito);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(mockCredito, response.getBody());
        verify(creditoService, times(1)).detalharCredito(numeroCredito);
    }
}

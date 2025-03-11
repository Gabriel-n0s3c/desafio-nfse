package com.desafio.nfse_api.feature.credito.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

class CreditoResponseDTOTest {

    private String numeroCredito;
    private String numeroNfse;
    private LocalDate dataConstituicao;
    private BigDecimal valorIssqn;
    private String tipoCredito;
    private String simplesNacional;
    private BigDecimal aliquota;
    private BigDecimal valorFaturado;
    private BigDecimal valorDeducao;
    private BigDecimal baseCalculo;

    @BeforeEach
    void setUp() {
        numeroCredito = "12345";
        numeroNfse = "67890";
        dataConstituicao = LocalDate.of(2024, 3, 10);
        valorIssqn = new BigDecimal("100.50");
        tipoCredito = "Simples";
        simplesNacional = "Sim";
        aliquota = new BigDecimal("5.00");
        valorFaturado = new BigDecimal("1000.00");
        valorDeducao = new BigDecimal("200.00");
        baseCalculo = new BigDecimal("800.00");
    }

    @Test
    void testGetterESetter() {
        CreditoResponseDTO dto = new CreditoResponseDTO();

        dto.setNumeroCredito(numeroCredito);
        dto.setNumeroNfse(numeroNfse);
        dto.setDataConstituicao(dataConstituicao);
        dto.setValorIssqn(valorIssqn);
        dto.setTipoCredito(tipoCredito);
        dto.setSimplesNacional(simplesNacional);
        dto.setAliquota(aliquota);
        dto.setValorFaturado(valorFaturado);
        dto.setValorDeducao(valorDeducao);
        dto.setBaseCalculo(baseCalculo);

        assertThat(dto.getNumeroCredito()).isEqualTo(numeroCredito);
        assertThat(dto.getNumeroNfse()).isEqualTo(numeroNfse);
        assertThat(dto.getDataConstituicao()).isEqualTo(dataConstituicao);
        assertThat(dto.getValorIssqn()).isEqualTo(valorIssqn);
        assertThat(dto.getTipoCredito()).isEqualTo(tipoCredito);
        assertThat(dto.getSimplesNacional()).isEqualTo(simplesNacional);
        assertThat(dto.getAliquota()).isEqualTo(aliquota);
        assertThat(dto.getValorFaturado()).isEqualTo(valorFaturado);
        assertThat(dto.getValorDeducao()).isEqualTo(valorDeducao);
        assertThat(dto.getBaseCalculo()).isEqualTo(baseCalculo);
    }

    @Test
    void testAllArgsConstructor() {
        CreditoResponseDTO dto = new CreditoResponseDTO(
                numeroCredito,
                numeroNfse,
                dataConstituicao,
                valorIssqn,
                tipoCredito,
                simplesNacional,
                aliquota,
                valorFaturado,
                valorDeducao,
                baseCalculo
        );

        assertThat(dto.getNumeroCredito()).isEqualTo(numeroCredito);
        assertThat(dto.getNumeroNfse()).isEqualTo(numeroNfse);
        assertThat(dto.getDataConstituicao()).isEqualTo(dataConstituicao);
        assertThat(dto.getValorIssqn()).isEqualTo(valorIssqn);
        assertThat(dto.getTipoCredito()).isEqualTo(tipoCredito);
        assertThat(dto.getSimplesNacional()).isEqualTo(simplesNacional);
        assertThat(dto.getAliquota()).isEqualTo(aliquota);
        assertThat(dto.getValorFaturado()).isEqualTo(valorFaturado);
        assertThat(dto.getValorDeducao()).isEqualTo(valorDeducao);
        assertThat(dto.getBaseCalculo()).isEqualTo(baseCalculo);
    }
}

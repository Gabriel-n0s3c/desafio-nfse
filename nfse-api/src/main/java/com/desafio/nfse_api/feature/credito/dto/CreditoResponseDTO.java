package com.desafio.nfse_api.feature.credito.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditoResponseDTO {

    @JsonProperty("numeroCredito")
    private String numeroCredito;

    @JsonProperty("numeroNfse")
    private String numeroNfse;

    @JsonProperty("dataConstituicao")
    private LocalDate dataConstituicao;

    @JsonProperty("valorIssqn")
    private BigDecimal valorIssqn;

    @JsonProperty("tipoCredito")
    private String tipoCredito;

    @JsonProperty("simplesNacional")
    private String simplesNacional;

    @JsonProperty("aliquota")
    private BigDecimal aliquota;

    @JsonProperty("valorFaturado")
    private BigDecimal valorFaturado;

    @JsonProperty("valorDeducao")
    private BigDecimal valorDeducao;

    @JsonProperty("baseCalculo")
    private BigDecimal baseCalculo;
}

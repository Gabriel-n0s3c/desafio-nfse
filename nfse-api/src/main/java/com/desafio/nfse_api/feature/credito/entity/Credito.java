package com.desafio.nfse_api.feature.credito.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "credito")
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_credito")
    private String numeroCredito;

    @Column(name = "numero_nfse")
    private String numeroNfse;

    @Column(name = "data_constituicao")
    private LocalDate dataConstituicao;

    @Column(name = "valor_issqn")
    private BigDecimal valorIssqn;

    @Column(name = "tipo_credito")
    private String tipoCredito;

    @Column(name = "simples_nacional")
    private boolean simplesNacional;

    @Column(name = "aliquota")
    private BigDecimal aliquota;

    @Column(name = "valor_faturado")
    private BigDecimal valorFaturado;

    @Column(name = "valor_deducao")
    private BigDecimal valorDeducao;

    @Column(name = "base_calculo")
    private BigDecimal baseCalculo;

    public boolean getSimplesNacional() {
        return simplesNacional;
    }
}

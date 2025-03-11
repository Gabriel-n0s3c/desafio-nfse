package com.desafio.nfse_api.feature.credito.controller;

import com.desafio.nfse_api.feature.credito.entity.Credito;
import com.desafio.nfse_api.feature.credito.repository.CreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CreditoControllerIntegracaoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CreditoRepository creditoRepository;

    @BeforeEach
    void setup() {
        creditoRepository.deleteAll();

        Credito credito = new Credito();
        credito.setNumeroCredito("12345");
        credito.setNumeroNfse("54321");
        credito.setDataConstituicao(LocalDate.now());
        credito.setValorIssqn(BigDecimal.valueOf(100.00));
        credito.setTipoCredito("Normal");
        credito.setSimplesNacional(false);
        credito.setAliquota(BigDecimal.valueOf(5.00));
        credito.setValorFaturado(BigDecimal.valueOf(500.00));
        credito.setValorDeducao(BigDecimal.ZERO);
        credito.setBaseCalculo(BigDecimal.valueOf(500.00));

        creditoRepository.save(credito);
    }

    @Test
    void deveRetornarListaDeCreditosPorNfse() throws Exception {
        mockMvc.perform(get("/api/creditos/54321")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeroCredito").value("12345"));
    }

    @Test
    void deveRetornarDetalhesDoCredito() throws Exception {
        mockMvc.perform(get("/api/creditos/credito/12345")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroCredito").value("12345"));
    }
}

package com.desafio.nfse_api.feature.credito.controller;
import com.desafio.nfse_api.feature.credito.dto.CreditoResponseDTO;
import com.desafio.nfse_api.feature.credito.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoResponseDTO>> listarCreditosByNfse(@PathVariable String numeroNfse) {
        List<CreditoResponseDTO> creditos = creditoService.listarCreditosByNfse(numeroNfse);
        return ResponseEntity.ok(creditos);
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoResponseDTO> detalharCredito(@PathVariable String numeroCredito) {
        CreditoResponseDTO credito = creditoService.detalharCredito(numeroCredito);
        return ResponseEntity.ok(credito);
    }

}

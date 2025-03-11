package com.desafio.nfse_api.feature.credito.repository;
import com.desafio.nfse_api.feature.credito.entity.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {
        List<Credito> findAllByNumeroNfse(String numeroNfse);
}

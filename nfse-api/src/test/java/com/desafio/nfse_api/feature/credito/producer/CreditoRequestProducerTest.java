package com.desafio.nfse_api.feature.credito.producer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class CreditoRequestProducerTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private CreditoRequestProducer creditoRequestProducer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Value("${topico.kafka.credito.request}")
    private  String creditoRequestTopicName;

    @Test
    void testSendMessage() {
        String tipoConsulta = "NFS-e";
        String numeroConsulta = "123456789";
        String expectedMessage = "Consulta por NFS-e, utilizando número: 123456789";

        creditoRequestProducer.sendMessage(tipoConsulta, numeroConsulta);

        verify(kafkaTemplate, times(1)).send(creditoRequestTopicName, expectedMessage);
    }
}

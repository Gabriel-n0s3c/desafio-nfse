package com.desafio.nfse_api.feature.credito.producer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreditoRequestProducer {

    @Value("${topico.kafka.credito.request}")
    private  String creditoRequestTopicName;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String tipoConsulta, String numeroConsulta) {
        String mensagem = "Consulta por "+ tipoConsulta + ", utilizando número: "+ numeroConsulta;
        this.kafkaTemplate.send(creditoRequestTopicName, mensagem);
    }
}

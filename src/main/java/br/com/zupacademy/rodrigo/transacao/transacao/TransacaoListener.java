package br.com.zupacademy.rodrigo.transacao.transacao;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {

	@Autowired
	TransacaoRepository transacaoRepository;

	Logger logger = LoggerFactory.getLogger(TransacaoListener.class);

	@KafkaListener(topics = "${spring.kafka.topic.transacoes}")
	public void listen(@Valid @Payload TransacaoRequest transacaoRequest) {
		Transacao transacao = transacaoRequest.toModel();
		transacaoRepository.save(transacao);
		logger.info("Transação de UUID " + transacaoRequest.getId() + " salva com sucesso.");
	}

}

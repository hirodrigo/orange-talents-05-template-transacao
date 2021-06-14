package br.com.zupacademy.rodrigo.transacao.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListenerConfigurer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistrar;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import br.com.zupacademy.rodrigo.transacao.transacao.TransacaoRequest;

@Configuration
@EnableKafka
public class KafkaConfiguration implements KafkaListenerConfigurer {

	private final KafkaProperties kafkaProperties;

	private final LocalValidatorFactoryBean validator;

	public KafkaConfiguration(KafkaProperties kafkaProperties, LocalValidatorFactoryBean validator) {
		this.kafkaProperties = kafkaProperties;
		this.validator = validator;
	}

	public Map<String, Object> consumerConfigurations() {
		Map<String, Object> properties = new HashMap<>();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				kafkaProperties.getConsumer().getKeyDeserializer());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				kafkaProperties.getConsumer().getValueDeserializer());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());

		return properties;
	}

	@Bean
	public ConsumerFactory<String, TransacaoRequest> transactionConsumerFactory() {
		StringDeserializer stringDeserializer = new StringDeserializer();
		JsonDeserializer<TransacaoRequest> jsonDeserializer = new JsonDeserializer<>(TransacaoRequest.class, false);

		return new DefaultKafkaConsumerFactory<>(consumerConfigurations(), stringDeserializer, jsonDeserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TransacaoRequest> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, TransacaoRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(transactionConsumerFactory());

		return factory;
	}

	@Override
	public void configureKafkaListeners(KafkaListenerEndpointRegistrar registrar) {
		registrar.setValidator(this.validator);
	}

}

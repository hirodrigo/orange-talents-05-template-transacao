package br.com.zupacademy.rodrigo.transacao.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class CartaoTransacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String uuid;

	@NotBlank
	private String email;

	/**
	 * No argument constructor for Hibernate, should not be used.
	 */
	@Deprecated
	public CartaoTransacao() {
	}

	public CartaoTransacao(String uuid, String email) {
		this.uuid = uuid;
		this.email = email;
	}

}

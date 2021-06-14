package br.com.zupacademy.rodrigo.transacao.transacao.cartao;

import javax.validation.constraints.NotBlank;

public class CartaoTransacaoRequest {

	@NotBlank
	private String id;

	@NotBlank
	private String email;

	@Deprecated
	public CartaoTransacaoRequest() {
	}

	public CartaoTransacaoRequest(@NotBlank String id, @NotBlank String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public CartaoTransacao toModel() {
		return new CartaoTransacao(this.id, this.email);
	}

}

package br.com.zupacademy.rodrigo.transacao.transacao.estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoTransacaoRequest {

	@NotBlank
	private String nome;

	@NotBlank
	private String cidade;

	@NotBlank
	private String endereco;

	@Deprecated
	public EstabelecimentoTransacaoRequest() {
	}

	public EstabelecimentoTransacaoRequest(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public EstabelecimentoTransacao toModel() {
		return new EstabelecimentoTransacao(this.nome, this.cidade, this.endereco);
	}

}

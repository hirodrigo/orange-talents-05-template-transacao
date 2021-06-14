package br.com.zupacademy.rodrigo.transacao.transacao.estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoTransacaoResponse {
	
	@NotBlank
	private String nome;

	@NotBlank
	private String cidade;

	@NotBlank
	private String endereco;

	public EstabelecimentoTransacaoResponse(EstabelecimentoTransacao estabelecimento) {
		this.nome = estabelecimento.getNome();
		this.cidade = estabelecimento.getCidade();
		this.endereco = estabelecimento.getEndereco();
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
	
}

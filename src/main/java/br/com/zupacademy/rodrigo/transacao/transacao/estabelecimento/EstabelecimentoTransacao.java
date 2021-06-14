package br.com.zupacademy.rodrigo.transacao.transacao.estabelecimento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class EstabelecimentoTransacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String cidade;

	@NotBlank
	private String endereco;

	@Deprecated
	public EstabelecimentoTransacao() {
	}

	public EstabelecimentoTransacao(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

}

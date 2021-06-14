package br.com.zupacademy.rodrigo.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.rodrigo.transacao.transacao.cartao.CartaoTransacao;
import br.com.zupacademy.rodrigo.transacao.transacao.estabelecimento.EstabelecimentoTransacao;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String uuid;

	@NotNull
	@Positive
	private BigDecimal valor;

	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.PERSIST)
	private EstabelecimentoTransacao estabelecimento;

	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.PERSIST)
	private CartaoTransacao cartao;

	@NotNull
	private LocalDateTime efetivadaEm;

	/**
	 * No argument constructor for Hibernate, should not be used.
	 */
	@Deprecated
	public Transacao() {
	}

	public Transacao(@NotBlank String uuid, @NotNull @Positive BigDecimal valor,
			@NotNull @Valid EstabelecimentoTransacao estabelecimento, @NotNull @Valid CartaoTransacao cartao,
			@NotNull LocalDateTime efetivadaEm) {
		this.uuid = uuid;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getUuid() {
		return uuid;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoTransacao getEstabelecimento() {
		return estabelecimento;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

}

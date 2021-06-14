package br.com.zupacademy.rodrigo.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.rodrigo.transacao.transacao.estabelecimento.EstabelecimentoTransacaoResponse;

public class TransacaoResponse {

	private String id;

	private BigDecimal valor;

	private EstabelecimentoTransacaoResponse estabelecimento;

	private LocalDateTime efetivadaEm;

	public TransacaoResponse(Transacao transacao) {
		this.id = transacao.getUuid();
		this.valor = transacao.getValor();
		this.estabelecimento = new EstabelecimentoTransacaoResponse(transacao.getEstabelecimento());
		this.efetivadaEm = transacao.getEfetivadaEm();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoTransacaoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

}

package br.com.zupacademy.rodrigo.transacao.transacao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

	@Autowired
	TransacaoRepository transacaoRepository;

	@GetMapping("/{uuid}")
	public ResponseEntity<List<TransacaoResponse>> showTransacoes(@PathVariable(required = true) String uuid,
			@PageableDefault(page = 0, size = 10, sort = "efetivadaEm", direction = Direction.DESC) Pageable pageable) {
		Page<Transacao> listaTransacoes = transacaoRepository.findByCartaoUuid(uuid, pageable);
		if (listaTransacoes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		List<TransacaoResponse> listaTransacoesResponse = listaTransacoes.stream()
				.map(transacao -> new TransacaoResponse(transacao)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaTransacoesResponse);
	}

}

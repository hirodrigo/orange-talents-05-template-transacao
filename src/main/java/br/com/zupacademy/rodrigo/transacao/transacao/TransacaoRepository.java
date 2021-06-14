package br.com.zupacademy.rodrigo.transacao.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, Long>{
	
	Page<Transacao> findByCartaoUuid(String uuid, Pageable pageable);

}

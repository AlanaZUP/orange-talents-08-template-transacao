package com.zupacademy.transacoes.transacao;

import com.zupacademy.transacoes.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    Optional<Transacao> findByIdOrigin(String idOrigin);

    List<Transacao> findTop10ByCartao(Cartao cartao);
}

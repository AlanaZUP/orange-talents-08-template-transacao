package com.zupacademy.transacoes.estabelecimento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

    Optional<Estabelecimento> findByNomeAndCidadeAndEndereco(String nome, String cidade, String endereco);
}

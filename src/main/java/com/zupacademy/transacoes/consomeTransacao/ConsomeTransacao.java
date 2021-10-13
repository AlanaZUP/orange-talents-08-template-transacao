package com.zupacademy.transacoes.consomeTransacao;

import com.zupacademy.transacoes.cartao.Cartao;
import com.zupacademy.transacoes.cartao.CartaoRepository;
import com.zupacademy.transacoes.estabelecimento.Estabelecimento;
import com.zupacademy.transacoes.estabelecimento.EstabelecimentoRepository;
import com.zupacademy.transacoes.transacao.Transacao;
import com.zupacademy.transacoes.transacao.TransacaoDtoForm;
import com.zupacademy.transacoes.transacao.TransacaoRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ConsomeTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @KafkaListener(topics = "${spring.kafka.topic}")
    @Transactional
    private void consome(TransacaoDtoForm transacaoDtoForm) throws IllegalArgumentException {
        transacaoRepository.findByIdOrigin(transacaoDtoForm.getId())
                .ifPresent(transacao -> {
                    throw new IllegalArgumentException("Já existe transação com o id " + transacaoDtoForm.getId());
                });

        Cartao cartao = transacaoDtoForm.getCartao().toModel();
        cartao = cartaoRepository.findByIdOrigin(cartao.getIdOrigin()).orElse(cartaoRepository.save(cartao));

            Estabelecimento estabelecimento = transacaoDtoForm.getEstabelecimento().toModel();
        estabelecimento = estabelecimentoRepository.findByNomeAndCidadeAndEndereco(estabelecimento.getNome(), estabelecimento.getCidade(), estabelecimento.getEndereco()).orElse(estabelecimentoRepository.save(estabelecimento));

        Transacao transacao = transacaoDtoForm.toModel(estabelecimento, cartao);

        transacaoRepository.save(transacao);
    }
}

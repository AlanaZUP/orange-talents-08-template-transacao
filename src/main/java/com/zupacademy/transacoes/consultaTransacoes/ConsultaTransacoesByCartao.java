package com.zupacademy.transacoes.consultaTransacoes;

import com.zupacademy.transacoes.cartao.Cartao;
import com.zupacademy.transacoes.cartao.CartaoRepository;
import com.zupacademy.transacoes.transacao.Transacao;
import com.zupacademy.transacoes.transacao.TransacaoDtoForm;
import com.zupacademy.transacoes.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
public class ConsultaTransacoesByCartao {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("/{id}/transacoes")
    @ResponseStatus(HttpStatus.OK)
    public void consulta(@PathVariable("id") String idOrigin){
        var teste = cartaoRepository.findByIdOrigin(idOrigin).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cartão com a identificação recebida");
        });
        transacaoRepository.findByIdOrigin("1");
//
//        List<Transacao> transacoes = transacaoRepository.findTop10ByCartao(cartao);
//        return transacoes.stream()
//                .map(TransacaoResponse::new)
//                .collect(Collectors.toList());
    }
}

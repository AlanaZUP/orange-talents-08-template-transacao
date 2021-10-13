package com.zupacademy.transacoes.consultaTransacoes;

import com.zupacademy.transacoes.estabelecimento.Estabelecimento;
import com.zupacademy.transacoes.transacao.Transacao;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private Long id;
    private String idOrigin;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoDtoResponse estabelecimento;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.idOrigin = transacao.getIdOrigin();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.estabelecimento = new EstabelecimentoDtoResponse(transacao.getEstabelecimento());
    }

    public Long getId() {
        return id;
    }

    public String getIdOrigin() {
        return idOrigin;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoDtoResponse getEstabelecimento() {
        return estabelecimento;
    }
}

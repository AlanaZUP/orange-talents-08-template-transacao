package com.zupacademy.transacoes.transacao;

import com.zupacademy.transacoes.cartao.Cartao;
import com.zupacademy.transacoes.cartao.CartaoDtoForm;
import com.zupacademy.transacoes.estabelecimento.Estabelecimento;
import com.zupacademy.transacoes.estabelecimento.EstabelecimentoDtoForm;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDtoForm {
    @NotBlank
    private String id;
    @NotNull
    private BigDecimal valor;
    @DateTimeFormat
    private LocalDateTime efetivadaEm;
    @NotNull
    private EstabelecimentoDtoForm estabelecimento;
    @NotNull
    private CartaoDtoForm cartao;

    @Deprecated
    public TransacaoDtoForm() {
    }

    public TransacaoDtoForm(String id, BigDecimal valor, LocalDateTime efetivadaEm, EstabelecimentoDtoForm estabelecimento, CartaoDtoForm cartao) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public Transacao toModel(Estabelecimento estabelecimentoModel, Cartao cartaoModel){
        return new Transacao(id, valor, efetivadaEm, estabelecimentoModel, cartaoModel);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoDtoForm getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDtoForm getCartao() {
        return cartao;
    }
}

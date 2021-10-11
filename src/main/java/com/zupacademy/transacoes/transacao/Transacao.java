package com.zupacademy.transacoes.transacao;

import com.zupacademy.transacoes.cartao.Cartao;
import com.zupacademy.transacoes.estabelecimento.Estabelecimento;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String idOrigin;
    @NotNull
    private BigDecimal valor;
    @DateTimeFormat
    private LocalDateTime efetivadaEm;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Estabelecimento estabelecimento;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idOrigin, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento, Cartao cartao) {
        this.idOrigin = idOrigin;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
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

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }
}

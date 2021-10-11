package com.zupacademy.transacoes.cartao;

import com.zupacademy.transacoes.transacao.Transacao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Table(name = "cartao")
@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String idOrigin;
    @NotBlank
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String idOrigin, String email) {
        this.idOrigin = idOrigin;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getIdOrigin() {
        return idOrigin;
    }

    public String getEmail() {
        return email;
    }
}
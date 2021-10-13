package com.zupacademy.transacoes.consultaTransacoes;

import com.zupacademy.transacoes.estabelecimento.Estabelecimento;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class EstabelecimentoDtoResponse {

    private Long id;
    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoDtoResponse(Estabelecimento estabelecimento) {
        this.id = estabelecimento.getId();
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}

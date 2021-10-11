package com.zupacademy.transacoes.cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoDtoForm {
    @NotBlank
    private String id;
    @NotBlank
    private String email;

    @Deprecated
    public CartaoDtoForm() {
    }

    public CartaoDtoForm(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public Cartao toModel(){
        return new Cartao(id, email);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Papel implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Modulo nome;

    @ManyToOne
    @JsonIgnore
    private Usuario usuario;

    @Override
    public String getAuthority() {
        return nome.toString();
    }

    public enum Modulo {
        DASHBOARD("ROLE_ADM"), USUARIO("ROLE_CLI");
        private String modulo;

        private Modulo(String modulo) {
            this.modulo = modulo;
        }

        @Override
        public String toString() {
            return this.modulo;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Modulo getNome() {
        return nome;
    }

    public void setNome(Modulo nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Papel [id=" + id + ", nome=" + nome + "]";
    }
}
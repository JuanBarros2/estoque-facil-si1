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
    private User user;

    @Override
    public String getAuthority() {
        return nome.toString();
    }

    public enum Modulo {
        ADM("ROLE_ADM"), CLI("ROLE_CLI");
        private String modulo;

        private Modulo(String modulo) {
            this.modulo = modulo;
        }

        @Override
        public String toString() {
            return this.modulo;
        }

        public static class Constants {
            public static final String ADM = "ROLE_ADM";
            public static final String CLI = "ROLE_CLI";
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Papel [id=" + id + ", nome=" + nome + "]";
    }
}
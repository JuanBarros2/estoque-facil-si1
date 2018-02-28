package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Module nome;

    @ManyToOne
    @JsonIgnore
    private User user;

    @Override
    public String getAuthority() {
        return nome.toString();
    }

    public enum Module {
        ADM("ROLE_ADM"), CLI("ROLE_CLI");
        private String modulo;

        private Module(String modulo) {
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

    public Module getNome() {
        return nome;
    }

    public void setNome(Module nome) {
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
        return "Role [id=" + id + ", nome=" + nome + "]";
    }
}
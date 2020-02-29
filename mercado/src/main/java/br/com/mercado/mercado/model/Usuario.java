package br.com.mercado.mercado.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long cpf;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String confirmaSenha;

//    @Temporal(TemporalType.DATE)
  //  private LocalDate dataCadastro;

    public Usuario() {
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String cs) {
        if(cs.equals(this.senha)) {
            this.confirmaSenha = cs;
        }
    }

//    public LocalDate getDataCadastro() {
        //return dataCadastro;
    //}

    //public void setDataCadastro() {
      //  LocalDate agora= LocalDate.now();
        //this.dataCadastro = agora;
    //}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return cpf != null ? cpf.equals(usuario.cpf) : usuario.cpf == null;
    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }
}

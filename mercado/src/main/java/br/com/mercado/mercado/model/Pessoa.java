/*package br.com.mercado.mercado.model;

import br.com.mercado.mercado.repositorio.IRepositorioGenerico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"} )
public abstract class Pessoa <T, ID extends Serializable> implements IRepositorioGenerico<T, ID> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cpf;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String confirmaSenha;

//    @Temporal(TemporalType.DATE)
    //  private LocalDate dataCadastro;


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
    public String toString() {
        return "Pessoa{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", confirmaSenha='" + confirmaSenha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getCpf(), pessoa.getCpf()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getEmail(), pessoa.getEmail()) && Objects.equals(getLogin(), pessoa.getLogin()) && Objects.equals(getSenha(), pessoa.getSenha()) && Objects.equals(getConfirmaSenha(), pessoa.getConfirmaSenha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf(), getNome(), getEmail(), getLogin(), getSenha(), getConfirmaSenha());
    }
}
*/
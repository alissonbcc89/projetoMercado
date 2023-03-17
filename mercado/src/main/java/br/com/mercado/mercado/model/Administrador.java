package br.com.mercado.mercado.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Administrador extends Pessoa implements Serializable {

    private String ctps;

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    @Override
    public List<Pessoa> findByNomeIgnoreCaseContaining(String nome) {
        return null;
    }

    @Override
    public Pessoa findByCpf(Long cpf) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrador)) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(getCtps(), that.getCtps());
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "ctps='" + ctps + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCtps());
    }
}

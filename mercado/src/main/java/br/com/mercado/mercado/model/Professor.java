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
public class Professor extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ctped;

    public String getCtped() {
        return ctped;
    }

    public void setCtped(String ctped) {
        this.ctped = ctped;
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
        if (!(o instanceof Professor)) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(getCtped(), professor.getCtped());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCtped());
    }

    @Override
    public String toString() {
        return "Professor{" +
                "ctped='" + ctped + '\'' +
                '}';
    }
}

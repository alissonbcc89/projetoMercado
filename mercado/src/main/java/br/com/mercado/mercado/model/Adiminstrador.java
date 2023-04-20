/*package br.com.mercado.mercado.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


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

    @Override
    public <S extends Produto> S save(S s) {
        return null;
    }

    @Override
    public <S extends Produto> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Produto> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Produto> findAll() {
        return null;
    }

    @Override
    public Iterable<Produto> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Produto produto) {

    }

    @Override
    public void deleteAll(Iterable<? extends Produto> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
*/
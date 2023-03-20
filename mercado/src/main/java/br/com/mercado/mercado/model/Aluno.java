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
public class Aluno extends Pessoa implements Serializable{

    private static final long serialVersionUID = 1L;
    private float peso, altura;

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Aluno(float peso, float altura) {
        this.peso = peso;
        this.altura = altura;
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
        if (!(o instanceof Aluno)) return false;
        if (!super.equals(o)) return false;
        Aluno aluno = (Aluno) o;
        return Float.compare(aluno.getPeso(), getPeso()) == 0 && Float.compare(aluno.getAltura(), getAltura()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPeso(), getAltura());
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "peso=" + peso +
                ", altura=" + altura +
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
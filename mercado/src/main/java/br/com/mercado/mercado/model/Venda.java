package br.com.mercado.mercado.model;

//import lombok.AllArgsConstructor;
//import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//@AllArgsConstructor
//@Data
@Entity
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany
    private List<LinhaItem> linhaItem;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;

    public List<LinhaItem> getLinhaItem() {
        return linhaItem;
    }

    public void setLinhaItem(List<LinhaItem> linhaItem) {
        this.linhaItem = linhaItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venda)) return false;
        Venda venda = (Venda) o;
        return Objects.equals(getLinhaItem(), venda.getLinhaItem()) && Objects.equals(getId(), venda.getId()) && Objects.equals(getDescricao(), venda.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLinhaItem(), getId(), getDescricao());
    }

    @Override
    public String toString() {
        return "Venda{" +
                "linhaItem=" + linhaItem +
                ", id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

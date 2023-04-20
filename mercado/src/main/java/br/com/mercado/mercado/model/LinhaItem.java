package br.com.mercado.mercado.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class LinhaItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne
    Produto produto;


    private int quantidade = 1;

    private int totalnota;

    private double valor_unitario;

    private double valor_total;

    public LinhaItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = this.produto.getValorVenda();
    }



    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = this.produto.valorVenda * this.quantidade;
    }

    public int getTotalnota() {
        return totalnota;
    }

    public void setTotalnota(List<LinhaItem> li)  {
        this.totalnota = 0;

        for(int i = 0; i < li.size(); i++){
            this.totalnota += li.get(i).getValor_total();
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinhaItem)) return false;
        LinhaItem linhaItem = (LinhaItem) o;
        return Double.compare(linhaItem.getValor_unitario(), getValor_unitario()) == 0 && Double.compare(linhaItem.getValor_total(), getValor_total()) == 0 && Objects.equals(getId(), linhaItem.getId()) && Objects.equals(getProduto(), linhaItem.getProduto()) && Objects.equals(getQuantidade(), linhaItem.getQuantidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduto(), getQuantidade(), getValor_unitario(), getValor_total());
    }
}

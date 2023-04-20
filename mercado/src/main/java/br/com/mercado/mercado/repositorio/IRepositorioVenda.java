package br.com.mercado.mercado.repositorio;

import br.com.mercado.mercado.model.Cart;
import br.com.mercado.mercado.model.LinhaItem;
import br.com.mercado.mercado.model.Venda;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositorioVenda extends CrudRepository <Venda, Long> {



}

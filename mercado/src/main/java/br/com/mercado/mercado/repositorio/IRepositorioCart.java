package br.com.mercado.mercado.repositorio;

import br.com.mercado.mercado.model.Cart;
import br.com.mercado.mercado.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface IRepositorioCart extends CrudRepository<Produto, Long> {


}

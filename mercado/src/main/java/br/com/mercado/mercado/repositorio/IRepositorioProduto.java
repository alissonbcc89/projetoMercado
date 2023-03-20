package br.com.mercado.mercado.repositorio;

import br.com.mercado.mercado.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRepositorioProduto extends CrudRepository<Produto, Long> {

    List<Produto> findByNomeIgnoreCaseContaining(String nome);

  //  void update(Produto produto);

    void deleteById(Long id);

//     Produto findOne(Long id);
    //Produto findProdutoById(Long id);

   // Optional<Produto> findById(Long id);

    Produto getOne(Long id);

    //void updateProduto(Long id);

    //Produto getById(Long id);



    public Optional <Produto> findById(Long id);

    Produto findProdutoById(Long id);

    //void putById(Long id);



   //public Optional<Produto> findOne(Long id);

  //  public Produto findByIdAndNomeIgnoreCaseContaining(Long id,String nome);

  //  Produto findProdutosById(Long id);

   //Optional<Produto> findById(Long id);


 //  Optional<Produto> findOne(Long id);


}

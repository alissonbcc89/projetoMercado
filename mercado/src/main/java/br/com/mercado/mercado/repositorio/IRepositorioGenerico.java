package br.com.mercado.mercado.repositorio;

import br.com.mercado.mercado.model.Pessoa;
import br.com.mercado.mercado.model.Usuario;

import java.util.List;

public interface IRepositorioGenerico {

    List<Pessoa> findByNomeIgnoreCaseContaining(String nome);

    Pessoa findByCpf(Long cpf);

//     void deleteByCpf(Long cpf);

    // List<Usuario> findByNomeIgnoreCaseContaning(String nome);

    // Usuario findByNome(String nome);

//   void deleteById(Long cpf);

    // void deleteByCpf(Long cpf);

    //   Usuario getOne(Long id);

    //   void update(Usuario usuario);

//    Usuario findById(Long id);

    //Usuario findAllById(Long id);
}
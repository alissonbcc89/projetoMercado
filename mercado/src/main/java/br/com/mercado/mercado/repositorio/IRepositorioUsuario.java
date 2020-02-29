package br.com.mercado.mercado.repositorio;

import br.com.mercado.mercado.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRepositorioUsuario extends CrudRepository<Usuario, Long> {

    List<Usuario> findByNomeIgnoreCaseContaining(String nome);

    Usuario findByCpf(Long cpf);

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

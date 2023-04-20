package br.com.mercado.mercado.repositorio;

import br.com.mercado.mercado.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IRepositorioUsuario extends CrudRepository<Usuario, UUID> {

    Optional<Usuario> findByUsername(String username);


    Usuario findByCpf(Long cpf);

    void deleteById(Long cpf);
}

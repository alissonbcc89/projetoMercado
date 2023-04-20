package br.com.mercado.mercado.config.security;


import br.com.mercado.mercado.model.Usuario;
import br.com.mercado.mercado.repositorio.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    final IRepositorioUsuario user;

    public UserDetailsServiceImp(IRepositorioUsuario user) {
        this.user = user;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = user.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao found with username:" + username));
        return new User(usuario.getUsername(), usuario.getPassword(), true,true,true,true, usuario.getAuthorities());



    }
}

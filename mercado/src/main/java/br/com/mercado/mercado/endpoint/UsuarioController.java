package br.com.mercado.mercado.endpoint;

import br.com.mercado.mercado.error.ResourceNotFoundException;
import br.com.mercado.mercado.model.Usuario;
import br.com.mercado.mercado.repositorio.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;




@RestController
@RequestMapping("/user")
public class UsuarioController {

    private IRepositorioUsuario repUsuario;

    @Autowired
    public UsuarioController(IRepositorioUsuario ru)
    {
        this.repUsuario = ru;
    }

    @GetMapping
    public ModelAndView listar()
    {
        ModelAndView modelAndView = new ModelAndView("userteste/listarusuarios");
        modelAndView.addObject("usuarios",repUsuario.findAll());
        return  modelAndView;

    }

    @GetMapping("/delete/{cpf}")
    public ModelAndView deletar(@PathVariable("cpf") Long cpf)
    {
        repUsuario.deleteById(cpf);
        return listar();
    }

    @GetMapping(path = "/adduser")
    public ModelAndView adduser(Usuario usuario)
    {

        ModelAndView mode= new ModelAndView("userteste/userAdd");
        mode.addObject("usuario", usuario);

        return mode;
    }

    @PostMapping(path = "/save")
    public ModelAndView save(@Valid Usuario usuario, BindingResult result)
    {
        if(result.hasErrors())
        {
            return  adduser(usuario);
        }

        repUsuario.save(usuario);
        return listar();
    }

    @GetMapping("/editar/{cpf}")
    public ModelAndView editar(@PathVariable ("cpf") Long cpf)
    {
        verifyUserExists(cpf);

        Usuario usuario = repUsuario.findByCpf(cpf);
        return adduser(usuario);
    }

    private void verifyUserExists(Long cpf)
    {
        if(repUsuario.findByCpf(cpf) == null )
            throw new ResourceNotFoundException("Student not found for CPF:" +cpf);
    }

}

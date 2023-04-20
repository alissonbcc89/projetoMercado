/*package br.com.mercado.mercado.endpoint;

import br.com.mercado.mercado.endpoint.error.ResourceNotFoundException;
import br.com.mercado.mercado.model.Usuario;
import br.com.mercado.mercado.repositorio.IRepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;




@RestController
public class UsuarioController {

    private IRepositorioUsuario repUsuario;

    private IndexController ic;

    @Autowired
    public UsuarioController(IRepositorioUsuario ru)
    {
        this.repUsuario = ru;
    }

    @GetMapping("/listaruser")
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

    @GetMapping(path = "/useradd")
    public ModelAndView add(Usuario usuario)
    {

        ModelAndView mode= new ModelAndView("/login");
        mode.addObject("usuario", usuario);

        repUsuario.save(usuario);

        return ic.login();
    }

    @PostMapping(path = "/usersave")
    public ModelAndView save(@Valid Usuario usuario, BindingResult result)
    {
        /*if(result.hasErrors())
        {
            return  adduser(usuario);
        }*/

       // repUsuario.save(usuario);
        //return ic.login();
    //}



    /*@GetMapping("/editar/{cpf}")
    public String editar(@PathVariable ("cpf") Long cpf)
    {
        verifyUserExists(cpf);

        Usuario usuario = repUsuario.findByCpf(cpf);
        return listar();
    }*/

  /*  private void verifyUserExists(Long cpf)
    {
        if(repUsuario.findByCpf(cpf) == null )
            throw new ResourceNotFoundException("Student not found for CPF:" +cpf);
    }

}
*/
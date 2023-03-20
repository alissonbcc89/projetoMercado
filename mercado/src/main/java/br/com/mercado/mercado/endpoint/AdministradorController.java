/*
package br.com.mercado.mercado.endpoint;

import br.com.mercado.mercado.error.ResourceNotFoundException;
import br.com.mercado.mercado.model.Produto;
import br.com.mercado.mercado.repositorio.IRepositorioGenerico;
import br.com.mercado.mercado.repositorio.IRepositorioProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;


@RestController
public class AdministradorController {

    private IRepositorioGenerico administradores;

    @Autowired
    public AdministradorController(IRepositorioGenerico rg)
    {
        this.administradores=rg;
    }

    @GetMapping(path = "/Administradores")
    public ModelAndView listar(){
            /*ModelAndView mv = new ModelAndView();
//mv.setViewName("/views/stat/schedule"); //뷰 파일 앞에 /를 붙이는게 문제
mv.setViewName("views/stat/schedule");
        ModelAndView modelAndView = new ModelAndView("/administrador/listaradm");
//            modelAndView.setViewName("listarprodutos");
//            Map<Produto,Long> prod = produtoDAO.findAll();
        modelAndView.addObject("administradores",administradores.findAll());
//           modelAndView.addObject("produto", new IRepositorioProduto());

        return modelAndView;
    }



}*/

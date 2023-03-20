package br.com.mercado.mercado.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class CartController {

    @GetMapping(path = "/cart")
    public ModelAndView chamarCarrinho(){
        ModelAndView mv = new ModelAndView("/carrinho/carrinho");
        //mv.addObject("produtos",prod.findAll());
        return mv;
    }

}

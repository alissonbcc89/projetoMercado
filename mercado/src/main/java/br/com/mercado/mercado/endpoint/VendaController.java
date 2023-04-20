package br.com.mercado.mercado.endpoint;


import br.com.mercado.mercado.model.LinhaItem;
import br.com.mercado.mercado.model.Produto;
import br.com.mercado.mercado.model.Venda;
import br.com.mercado.mercado.repositorio.IRepositorioProduto;
import br.com.mercado.mercado.repositorio.IRepositorioVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class VendaController {

    private IRepositorioVenda vendas;
    private IRepositorioProduto prod;

    public static List<LinhaItem> linhaItens;
    Produto produto;



    @Autowired
    public VendaController(IRepositorioVenda vendas, IRepositorioProduto prod) {

        this.vendas = vendas;
        this.prod = prod;
    }
//retorna todas as vendas executadas
    @GetMapping(path = "/listvenda")
    public ModelAndView listarr(){
        ModelAndView modelAndView = new ModelAndView("/carrinho/listarprodutosvenda");
        modelAndView.addObject("produtos",prod.findAll());
        return modelAndView;
    }

    //criar insercao de produtos na lista de linha de itens
   @PostMapping("/itenadd/{id}")
    public void iten(@PathVariable("id") Long id, Produto pr) {
        LinhaItem li = new LinhaItem();
       Produto p = prod.findProdutoById(pr.getId());
       li.setProduto(p);
       li.setId((long) (linhaItens.size()+1));
       linhaItens.add(li);

        System.out.println(produto.getNome());

    }

    @GetMapping("/nota")
    public ModelAndView add() {

        double totalnota = 0;

        for(int i = 0; i < linhaItens.size();i++){
            totalnota+= linhaItens.get(i).getValor_total();
        }

        ModelAndView mv = new ModelAndView("/carrinho/carrinho");
        //modelAndView.addObject("produtos",prod.findAll());
        mv.addObject("linhasItens", linhaItens );

        return mv;
    }



    @PostMapping("/savevenda")
    public ModelAndView savevenda(Venda venda, BindingResult result) {

        //if(result.hasErrors()) {
          //  return add(cart);
        //}



        vendas.save(venda);


        return listarr();
    }


}

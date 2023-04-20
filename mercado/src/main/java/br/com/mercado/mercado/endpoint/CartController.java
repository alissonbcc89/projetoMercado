/*package br.com.mercado.mercado.endpoint;

import br.com.mercado.mercado.model.LinhaItem;
import br.com.mercado.mercado.model.Produto;
import br.com.mercado.mercado.model.Venda;
import br.com.mercado.mercado.repositorio.IRepositorioProduto;
import br.com.mercado.mercado.repositorio.IRepositorioVenda;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
public class CartController {

    List<LinhaItem> itens;


    Venda venda;

    IRepositorioVenda vendas;
    IRepositorioProduto prod;

    @GetMapping(path = "/cart")
    public ModelAndView vizualizar(){
        ModelAndView mv = new ModelAndView("/carrinho/carrinho");
        return mv;
    }

    @GetMapping("/cartadd")
    public ModelAndView add(LinhaItem linhaItem) {
        //rodutoById());
        boolean passou = false;
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getProduto().getId().equals(linhaItem.getProduto().getId())){
                passou = true;
                itens.get(i).setQuantidade(linhaItem.getQuantidade());
                break;
            }
        }
        if(passou == false){
            this.itens.add(linhaItem);
        }


        ModelAndView mv = new ModelAndView("/carrinho/carrinho");
        mv.addObject("Carrinho",itens);

        return mv;
    }

    @PostMapping("/cartsave")
    public ModelAndView savecart(LinhaItem linhaItems, BindingResult result) {

        //if(result.hasErrors()) {
        //  return add(linhaItems);
        //}
        // produto.setId(prod.findProdutoById());
        boolean passou = false;

        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getProduto().getId().equals(linhaItems.getProduto().getId())){
                this.itens.get(i).setQuantidade(linhaItems.getQuantidade());
                passou = true;
                break;
        }

    }
        if(passou == false){
            this.itens.add(linhaItems);
        }


        ModelAndView mv = new ModelAndView("/carrinho/carrinho");
        mv.addObject("Carrinho",itens);

        return mv;
    }

    @GetMapping(path = "/prod")
    public ModelAndView listarcartqnt(){
            /*ModelAndView mv = new ModelAndView();
//mv.setViewName("/views/stat/schedule"); //뷰 파일 앞에 /를 붙이는게 문제
mv.setViewName("views/stat/schedule"); */
        /*ModelAndView modelAndView = new ModelAndView("/cart/listarprodutos");
//            modelAndView.setViewName("listarprodutos");
//            Map<Produto,Long> prod = produtoDAO.findAll();
        modelAndView.addObject("produtos",prod.findAll());
//           modelAndView.addObject("produto", new IRepositorioProduto());

        return modelAndView;
    }

    @RequestMapping("/nota")
    public ModelAndView nota(List<LinhaItem> linhaItens){
        ModelAndView modelAndView = new ModelAndView("/carrinho/listarcupom");
        modelAndView.addObject("venda",linhaItens);


        return modelAndView;

    }
    @PostMapping("/cartvenda")
    public ModelAndView venda( BindingResult result) {
        // antes de finalizar a venda devo passar pelo repositorio produto e retirar
        //a quantia de intens adcionado ao produto
        for(int i = 0; i < itens.size(); i++) {
            if(prod.findById(itens.get(i).getProduto().getId()) != null){
                //if(prod.findById(itens.get(i).getProduto().getId());
                Produto p = prod.getOne(itens.get(i).getProduto().getId());
                if(p.getQuantidade() >= itens.get(i).getQuantidade()) {
                    p.setQuantidade(p.getQuantidade() - itens.get(i).getQuantidade());
                }
            }
        }


//preciso transforma a linha de itens em venda antes de adc ao banco
        //a venda ainda nao foi criada aparti das linhas de itens

        vendas.save(venda);

        ModelAndView modelAndView = new ModelAndView("/carrinho/carrinho");
//            modelAndView.setViewName("listarprodutos");
//            Map<Produto,Long> prod = produtoDAO.findAll();
        modelAndView.addObject("Carrinho de Compras",prod.findAll());
//           modelAndView.addObject("produto", new IRepositorioProduto());

        return modelAndView;
    }

}
*/
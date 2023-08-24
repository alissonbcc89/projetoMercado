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

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@RestController
public class VendaController {

    private IRepositorioVenda vendas;
    private IRepositorioProduto prod;

    LinhaItem linha;

    public  List<LinhaItem> linhaIten = new List<LinhaItem>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<LinhaItem> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(LinhaItem linhaItem) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends LinhaItem> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends LinhaItem> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public LinhaItem get(int index) {
            return null;
        }

        @Override
        public LinhaItem set(int index, LinhaItem element) {
            return null;
        }

        @Override
        public void add(int index, LinhaItem element) {

        }

        @Override
        public LinhaItem remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<LinhaItem> listIterator() {
            return null;
        }

        @Override
        public ListIterator<LinhaItem> listIterator(int index) {
            return null;
        }

        @Override
        public List<LinhaItem> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    Produto produto;

    @Autowired
    public VendaController(IRepositorioVenda vendas, IRepositorioProduto prod) {
        this.vendas = vendas;
        this.prod = prod;

    }

    @Autowired



//retorna todas as vendas executadas
    @GetMapping(path = "/listvenda")
    public ModelAndView listarr(){
        ModelAndView modelAndView = new ModelAndView("/carrinho/listarprodutosvenda");
        modelAndView.addObject("produtos",prod.findAll());
        return modelAndView;
    }

    //criar insercao de produtos na lista de linha de itens
   @PostMapping("/itenadd/{id}")
    public void iten(@PathVariable("id") Long id) {
        LinhaItem li = new LinhaItem();
       Produto p = prod.findProdutoById(id);
       li.setProduto(p);
       li.setValor_unitario(p.getValorVenda());
       //li.setTotalnota(p.getValorVenda()*)
       //li.setId((long) (linhaItens.size()+1));
       linhaIten.add(li);

        System.out.println(p.getNome());
    }

    @GetMapping("/nota")
    public ModelAndView add() {

       double totalnota = 0;

        for(int i = 0; i < linhaIten.size();i++){
            totalnota+= linhaIten.get(i).getValor_total();
        }
/* ModelAndView mv = new ModelAndView("/produto/postAdd");
        mv.addObject("produto", produto);*/
        ModelAndView mv = new ModelAndView("/carrinho/carrinho");
        //modelAndView.addObject("produtos",prod.findAll());
      //  mv.addObject("linhaIten",  );

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

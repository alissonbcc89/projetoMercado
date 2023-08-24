package br.com.mercado.mercado.endpoint;

import br.com.mercado.mercado.endpoint.error.ResourceNotFoundException;
import br.com.mercado.mercado.model.Produto;
import br.com.mercado.mercado.repositorio.IRepositorioProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@RestController
//@RequestMapping("produto")
public class ProdutoController  {


    private IRepositorioProduto prod;

    //
    private static String add;

    @Autowired
    public ProdutoController(IRepositorioProduto rp)
    {
        this.prod=rp;
    }

    @GetMapping(path = "/prod")
    public ModelAndView listar(){
            /*ModelAndView mv = new ModelAndView();
//mv.setViewName("/views/stat/schedule"); //뷰 파일 앞에 /를 붙이는게 문제
mv.setViewName("views/stat/schedule"); */
        ModelAndView modelAndView = new ModelAndView("/produto/listarprodutos");
//            modelAndView.setViewName("listarprodutos");
//            Map<Produto,Long> prod = produtoDAO.findAll();
        modelAndView.addObject("produtos",prod.findAll());
//           modelAndView.addObject("produto", new IRepositorioProduto());

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        verifyIfProdutoExists(id);
        prod.deleteById(id);

        return listar();
    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") long id, Produto pr) {
        //
        Produto p = prod.findProdutoById(pr.getId());
        //prod.save(p);
        p.setId((long) id);
        //prod.save(p);
        ModelAndView mv = new ModelAndView("produto/update");
        mv.addObject("produto", p);


        //return mv;

        return mv;



    }




    @GetMapping("/add")
    public ModelAndView add(Produto produto) {

        ModelAndView mv = new ModelAndView("/produto/postAdd");
        mv.addObject("produto", produto);

        return mv;
    }

    @PutMapping("/productupdate/{id}")
    public ModelAndView productupdate(@PathVariable(value = "id") long id , Produto produto, BindingResult result) {


        //Produto p = prod.findProdutoById(produto.getId());


        if(result.hasErrors()) {
            return add(produto);
        }


        // produto.setId(prod.findProdutoById());

        this.prod.save(produto);

        return listar();
    }

    @PostMapping("/save")
    public ModelAndView save(Produto produto, BindingResult result) {


        if(result.hasErrors()) {
            return add(produto);
        }
       // produto.setId(prod.findProdutoById());

        prod.save(produto);

        return listar();
    }


    /*GetMapping("/editarproduto/{id}")
    public ModelAndView eeditarproduto(@PathVariable("id") Long id){
        Produto p = prod.findProdutoById(id);

        ModelAndView mv = new ModelAndView("/produto/postAdd");
        mv.addObject("produto", p);

        return mv;

        //model.addAttribute("produto", p);

        //return listar();

    }*/







//Métodos para teste com o PostMan

    @RequestMapping("/teste")
    public ModelAndView index(){
        return new ModelAndView("listarprodutos");
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>( prod.findAll(), HttpStatus.OK);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProdutoById(@PathVariable Long id) {
        verifyIfProdutoExists(id);
        Optional<Produto> produto = prod.findById(id);
        if(produto == null )
            throw new ResourceNotFoundException("Student no found for ID:"+ id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping(path = "/findByNome/{nome}")
    public ResponseEntity<?> findProdutoByNome(@PathVariable String nome) {
        return new ResponseEntity<>(prod.findByNomeIgnoreCaseContaining(nome), HttpStatus.OK);
    }

    @PostMapping(path = "/salvar")
    public ResponseEntity<?> save(@RequestBody Produto produto) {
        return new ResponseEntity<>(prod.save(produto), HttpStatus.CREATED );
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> del(@PathVariable Long id) {
        verifyIfProdutoExists(id);
        prod.deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @PutMapping("/editt/{id}")
    public ResponseEntity<?> update(@RequestBody Produto produto) {
        verifyIfProdutoExists(produto.getId());
        prod.save(produto);
        return new ResponseEntity<>( HttpStatus.OK );

    }

    private void verifyIfProdutoExists(Long id){
        if(prod.findById(id)  == null)
            throw new ResourceNotFoundException("Student not found for ID:" +id);
    }

}
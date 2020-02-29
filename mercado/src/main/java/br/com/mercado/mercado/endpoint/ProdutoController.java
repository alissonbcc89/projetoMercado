package br.com.mercado.mercado.endpoint;

import br.com.mercado.mercado.error.ResourceNotFoundException;
import br.com.mercado.mercado.model.Produto;
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
//@RequestMapping("produto")
public class ProdutoController  {


    private IRepositorioProduto prod;

    @Autowired
    public ProdutoController(IRepositorioProduto rp)
    {
        this.prod=rp;
    }

    @GetMapping(path = "/")
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

    @GetMapping("/add")
    public ModelAndView add(Produto produto) {

        ModelAndView mv = new ModelAndView("produto/postAdd");
        mv.addObject("produto", produto);

        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Produto produto, BindingResult result) {

        if(result.hasErrors()) {
            return add(produto);
        }

        prod.save(produto);

        return listar();
    }



    @GetMapping("/edit/{id}")
    public ModelAndView edit(  @PathVariable("id") Long id) {
//        @PathVariable("id") Long id
        verifyIfProdutoExists(id);

        //prod.deleteById(id);
        Produto produto = prod.getOne(id);
//        update(produto);

//        prod.updateProduto(id);

//        Produto produto = produto.setId(id);
//        produto.setId(id);
     //   prod.deleteById(id);
        return  add(produto);

        /*  @PutMapping("/editt/{id}")
    public ResponseEntity<?> update(@RequestBody Produto produto) {
        verifyIfProdutoExists(produto.getId());
        prod.save(produto);
        return new ResponseEntity<>( HttpStatus.OK );

    } */
    }




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

    private  void verifyIfProdutoExists(Long id){
        if(prod.findById(id)  == null)
            throw new ResourceNotFoundException("Student not found for ID:" +id);
    }

}
/*package br.com.mercado.mercado.endpoint;

import br.com.mercado.mercado.model.Cliente;
import br.com.mercado.mercado.repositorio.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

// como dar um override em alguns dos métodos do repositório, vai ser útil para adicionar permissões via spring security
// http://stackoverflow.com/questions/34356700/spring-override-save-method-in-crudrepository

@RestController
@RequestMapping("cliente")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    public ClientController(ClientRepository cr) {

        this.clientRepository = cr;
    }
//   @Autowired
   // private AuthenticationFacade authenticationFacade;

  //  @Autowired
//    AppSettingsService appSettingsService;

    @GetMapping(path = "/client/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("client/list");
        modelAndView.addObject("title", "Lista de clientes");

        return modelAndView;
    }

    @GetMapping(value = "/client/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("client/register");
        modelAndView.addObject("title", "Cadastro de cliente");

        return modelAndView;
    }

    @GetMapping(path = "/client/{id}")
    public ModelAndView profile(@PathVariable Long id) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("client/profile");
        Optional<Cliente> client = clientRepository.findById(id);

        // @todo isso ainda não funciona direito
//        this.appSettingsService.addSettings("client", client);

        modelAndView.addObject("title", client);

        return modelAndView;
    }

    @GetMapping(path = "/client")
    public ModelAndView logUser(String email){
        ModelAndView modelAndView = new ModelAndView("client/profile");
        Cliente client = clientRepository.findByEmail(email);
        System.out.println("/n/n/n/n/n"+client+"/n/n/n/n/n/n");
        //this.appSettingsService.addSettings("client", client);
        return modelAndView;
    }
}
*/
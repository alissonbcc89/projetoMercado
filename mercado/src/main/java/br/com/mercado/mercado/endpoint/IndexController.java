package br.com.mercado.mercado.endpoint;

//import jdk.internal.icu.text.NormalizerBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    // Login form
    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    // Login form
    /*@RequestMapping("/login2.html")
    public String login() {
        return "login2.html";
    }*/

    /*@RequestMapping("/login-error.html")
    public ModelAndView loginError(Model model) {
        ModelAndView mvc = model.addAttribute("loginError", true);
        return "login";
    }*/



}

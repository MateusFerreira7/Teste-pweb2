package br.edu.ifal.usandocookies;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class CookieController {
    
    @GetMapping("/")
    public ModelAndView lerCookie (@CookieValue(value = "primeiro acesso", defaultValue = "sim") 
     String primeiroAcesso,HttpServletResponse response) {
      
        ModelAndView mv = new ModelAndView("index");
        if (primeiroAcesso.equals("sim")) {
            mv.addObject("msg", "Voce não está Vinculado");
          
        }
        else{
        mv.addObject("msg", "seja bem vindo" + primeiroAcesso);
            
        }
        return mv;
    }

   @PostMapping(value = "/adicionacookie")
    public ModelAndView mudaNomeCookie(HttpServletResponse response, String name) {

        Cookie c = new Cookie("primeiroAcesso", name);

        response.addCookie(c);

        return new ModelAndView("redirect:/");
        
    }

}
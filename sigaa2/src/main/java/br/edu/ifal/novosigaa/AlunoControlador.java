package br.edu.ifal.novosigaa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AlunoControlador{

    @Autowired
    AlunoRepositorio repo;

    @RequestMapping("/aluno/form")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("formaluno.html");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @RequestMapping("/aluno/salvar")
    public ModelAndView salvar(Aluno novoAluno) {
        repo.save(novoAluno);
        return new ModelAndView("redirect:/aluno/listar");
    }

    @RequestMapping("/aluno/listar")
    public ModelAndView listar() {
        ModelAndView resposta = new ModelAndView("listaalunos.html");
        resposta.addObject("alunos", repo.findAll());
        return resposta;
    }

    @RequestMapping("/aluno/excluir/{id}")
    public ModelAndView excluir(@PathVariable(name = "id") int id) {
        repo.deleteById(id);
        return new ModelAndView("redirect:/aluno/listar");
    }

    @RequestMapping("/aluno/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable(name = "id") int id) {
        ModelAndView resposta = new ModelAndView("formaluno.html");
        resposta.addObject("aluno", repo.findById(id).get());
        return resposta;
    }

}
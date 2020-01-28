package br.edu.ifal.novosigaa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class AlunoControladorTest extends AbstractTest{
    
    @Before
    @Override
    public void setUp() {
        super.setUp();
    }
    @Test
    public void deveRetornaUmaPaginaWebParaListagemDosAlunos() throws Exception {
        String uri = "/aluno/listar";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
        .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int statusRetornado = mvcResult.getResponse().getStatus();
        int statusEsperado = 200;

        assertEquals(statusEsperado, statusRetornado);
    }
     @Test
    public void testarCriancaoDeAluno()throws Exception {
        String uri = "/aluno/salvar";
        Aluno aluno = new Aluno();
        aluno.setNome("mateus");
        aluno.setCpf("465.545.454-84");
        aluno.setId(1);

        String inputJson = super.mapToJson(aluno);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
         .post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();

         int statusRecebido = mvcResult.getResponse().getStatus();
         int statusEsperado = 302;

         assertEquals(statusEsperado, statusRecebido);

    }

}
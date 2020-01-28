package br.edu.ifal.novosigaa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepositorio extends CrudRepository<Aluno, Integer>{

}
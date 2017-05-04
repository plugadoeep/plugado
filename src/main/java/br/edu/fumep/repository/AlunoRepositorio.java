package br.edu.fumep.repository;

import br.edu.fumep.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
public interface AlunoRepositorio  extends JpaRepository<Aluno, Long> {
}

package br.edu.fumep.repository;

import br.edu.fumep.entity.GrupoEstudoAluno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
public interface GrupoEstudoAlunoRepositorio  extends JpaRepository<GrupoEstudoAluno, Long> {
}

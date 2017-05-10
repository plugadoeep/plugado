package br.edu.fumep.repository;

import br.edu.fumep.entity.Aluno;
import br.edu.fumep.entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
public interface MensagemRepositorio  extends JpaRepository<Mensagem, Long> {
    @Query("select m1 from Mensagem m1 where m1.id in (select max(m.id) from Mensagem m inner join m.grupoEstudo ge inner join ge.gruposEstudoAluno gea where gea.aluno = ? group by gea.grupoEstudo)")
    List<Mensagem> mural(Aluno aluno);
}

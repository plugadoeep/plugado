package br.edu.fumep.specification;

import br.edu.fumep.entity.Aluno;
import br.edu.fumep.entity.Mensagem;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by arabasso on 10/05/2017.
 *
 */
public class MensagemMuralEspecificacao implements Specification<Mensagem> {
    private Aluno aluno;

    public MensagemMuralEspecificacao(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public Predicate toPredicate(Root<Mensagem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//        Subquery<Mensagem> sq = query.subquery(Mensagem.class);
//
//        Root<GrupoEstudo> grupoEstudo = sq.from(GrupoEstudo.class);
//
//        Join<GrupoEstudo, Mensagem> mensagemJoin = grupoEstudo.join("grupoEstudo");
//        Join<GrupoEstudoAluno, GrupoEstudo> grupoEstudoJoin = mensagemJoin.join("gruposEstudoAluno");
//
//        sq.select(grupoEstudoJoin).where(cb.equal(grupoEstudoJoin.get("aluno"), cb.parameter(Aluno.class, aluno)));

//        Root<Project> project = sq.from(Project.class);
//        Join<Project, Employee> sqEmp = project.join("employees");
//        sq.select(sqEmp).where(cb.equal(project.get("name"),
//                cb.parameter(String.class, projectName)));
//        return cb.in(root).value(sq);
        return null;
    }
}

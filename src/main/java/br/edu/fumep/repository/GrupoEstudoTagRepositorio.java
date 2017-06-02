package br.edu.fumep.repository;

import br.edu.fumep.entity.GrupoEstudoTag;
import br.edu.fumep.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
public interface GrupoEstudoTagRepositorio  extends JpaRepository<GrupoEstudoTag, Long> {
    List<GrupoEstudoTag> findByGrupoEstudoId(long id);

    Optional<GrupoEstudoTag> findByGrupoEstudoIdAndTagDescricao(long grupoEstudo, String descricao);
}

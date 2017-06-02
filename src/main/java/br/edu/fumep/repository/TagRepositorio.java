package br.edu.fumep.repository;

import br.edu.fumep.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
public interface TagRepositorio  extends JpaRepository<Tag, Long> {
    Tag findByDescricao(String tag);
}

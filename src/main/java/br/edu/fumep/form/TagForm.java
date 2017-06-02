package br.edu.fumep.form;

import br.edu.fumep.entity.GrupoEstudoTag;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by arabasso on 01/06/2017.
 */
public class TagForm {
    @NotBlank
    private String descricao;

    public TagForm(GrupoEstudoTag tag) {
        this.descricao = tag.getTag().getDescricao();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

package br.edu.fumep.form;

/**
 * Created by Leonardo Marchese on 02/05/2017.
 *
 */
public class GrupoEstudoAlunoForm {
    
   private long id;
   private long grupoEstudoId;
   private long alunoId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGrupoEstudoId() {
        return grupoEstudoId;
    }

    public void setGrupoEstudoId(long grupoEstudoId) {
        this.grupoEstudoId = grupoEstudoId;
    }

    public long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(long alunoId) {
        this.alunoId = alunoId;
    }


    
}

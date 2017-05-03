/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fumep.form;

import br.edu.fumep.entity.*;
import br.edu.fumep.entity.Aluno;

/**
 *
 * @author Leonardo Marchese
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

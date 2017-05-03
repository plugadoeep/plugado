/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fumep.entity;

import br.edu.fumep.entity.Aluno;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "mensagem")
public class Mensagem implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private GrupoEstudo grupoEstudo;
    private Aluno aluno;
    private String mensagem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GrupoEstudo getGrupoEstudo() {
        return grupoEstudo;
    }

    public void setGrupoEstudo(GrupoEstudo grupoEstudo) {
        this.grupoEstudo = grupoEstudo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    
    
    
    
}

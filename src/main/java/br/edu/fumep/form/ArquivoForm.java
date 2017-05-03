/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fumep.form;

import br.edu.fumep.entity.*;
import br.edu.fumep.entity.Aluno;
import java.util.Date;

/**
 *
 * @author Leonardo Marchese
 */
public class ArquivoForm {
    
    private long id;
    private Mensagem mensagem;
    private long grupoEstudoId;
    private long alunoId;
    private String nome;
    private Double tamanho;
    private String formato;
    private Date dataInclusao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    

   
    
    
}

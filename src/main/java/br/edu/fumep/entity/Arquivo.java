package br.edu.fumep.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by arabasso on 03/05/2017.
 *
 */
@Entity
@Table(name = "arquivo")
public class Arquivo implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Mensagem mensagem;
    @ManyToOne
    private GrupoEstudo grupoEstudo;
    @ManyToOne
    private Aluno aluno;
    @NotBlank
    private String nome;
    private Double tamanho;
    private String formato;
    private LocalDate dataInclusao;

    protected Arquivo() {
    }

    public Arquivo(Mensagem mensagem) {
        this.mensagem = mensagem;
        this.aluno = mensagem.getAluno();
        this.grupoEstudo = mensagem.getGrupoEstudo();
    }

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

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }
}

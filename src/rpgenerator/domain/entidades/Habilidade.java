package rpgenerator.domain.entidades;

import rpgenerator.domain.entidades.Enums.HabilidadeEnum;

public class Habilidade {
    private int id;
    private int id_classe;
    private HabilidadeEnum tipoHabilidade;
    private int custoDeMana;
    private int duracao;
    private int efeito;
    private String nome;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public HabilidadeEnum getTipoHabilidade() {
        return tipoHabilidade;
    }

    public void setTipoHabilidade(HabilidadeEnum tipoHabilidade) {
        this.tipoHabilidade = tipoHabilidade;
    }

    public int getCustoDeMana() {
        return custoDeMana;
    }

    public void setCustoDeMana(int custoDeMana) {
        this.custoDeMana = custoDeMana;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getEfeito() {
        return efeito;
    }

    public void setEfeito(int efeito) {
        this.efeito = efeito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
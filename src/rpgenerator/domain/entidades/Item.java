package rpgenerator.domain.entidades;

import rpgenerator.domain.entidades.Enums.ItemEnum;
import rpgenerator.domain.entidades.itens.AbstractFactoryItem;

public abstract class Item extends AbstractFactoryItem {
    private int id;
    private String nome;
    private ItemEnum tipo;
    private int efeito;
    private int preco;

    public abstract Personagem utilizar(Personagem persn);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemEnum getTipo() {
        return tipo;
    }

    public void setTipo(ItemEnum tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEfeito() {
        return efeito;
    }

    public void setEfeito(int efeito) {
        this.efeito = efeito;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
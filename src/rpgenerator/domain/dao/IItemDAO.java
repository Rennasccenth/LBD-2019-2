package rpgenerator.domain.dao;

import rpgenerator.domain.entidades.Item;

import java.util.List;

public interface IItemDAO {

    public void inserir(Item entidade);

    // Utiliza como chave para atualizar o item o id dele.
    public void atualizar(Item entidade);

    public void remover(int id);

    public List<Item> consultar();
}

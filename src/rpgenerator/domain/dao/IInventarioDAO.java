package rpgenerator.domain.dao;

import rpgenerator.domain.entidades.Inventario;

import java.util.List;

public interface IInventarioDAO {

    public void inserir(Inventario entidade);

    public void atualizar(Inventario entidade);

    public void remover(int id);

    public List<Inventario> consultar();
}

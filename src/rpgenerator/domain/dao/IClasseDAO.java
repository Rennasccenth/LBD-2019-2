package rpgenerator.domain.dao;

import rpgenerator.domain.entidades.Classe;

import java.util.List;

public interface IClasseDAO {

    public void inserir(Classe entidade);

    public void atualizar(Classe entidade);

    public void remover(int id);

    public List<Classe> consultar();
}

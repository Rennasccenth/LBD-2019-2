package rpgenerator.domain.dao;

import rpgenerator.domain.entidades.Habilidade;

import java.util.List;

public interface IHabilidadeDAO {

    public void inserir(Habilidade entidade);

    public void atualizar(Habilidade entidade);

    public void remover(int id);

    public List<Habilidade> consultar();
}

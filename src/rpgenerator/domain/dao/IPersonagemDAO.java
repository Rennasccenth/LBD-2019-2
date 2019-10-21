package rpgenerator.domain.dao;

import rpgenerator.domain.entidades.Personagem;

import java.util.List;

public interface IPersonagemDAO {

    public void inserir(Personagem entidade);

    public void atualizar(Personagem entidade);

    public void remover(int id);

    public List<Personagem> consultar();

}

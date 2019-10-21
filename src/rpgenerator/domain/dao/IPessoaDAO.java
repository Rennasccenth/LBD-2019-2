package rpgenerator.domain.dao;

import rpgenerator.domain.entidades.Personagem;
import rpgenerator.domain.entidades.Pessoa;

import java.util.List;

public interface IPessoaDAO {
    public void inserir(Pessoa entidade);

    public void atualizar(Pessoa entidade);

    public void remover(int id);

    public List<Pessoa> consultar();

}

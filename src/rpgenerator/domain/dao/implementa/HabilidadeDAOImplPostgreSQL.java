package rpgenerator.domain.dao.implementa;

import rpgenerator.domain.dao.IHabilidadeDAO;
import rpgenerator.domain.entidades.Habilidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabilidadeDAOImplPostgreSQL implements IHabilidadeDAO {

    public ArrayList<Habilidade> skills_da_classe(int id) {
        ArrayList<Habilidade> skills = new ArrayList<>();
        Connection con = criaConexao();

        String sql =
                "SELECT * " +
                "FROM habilidade " +
                "WHERE habilidade.id_classe = "+ id ;

        try {
            ResultSet res = con.createStatement().executeQuery(sql);
            while(res.next()) {
                Habilidade habilidade = new Habilidade();
                habilidade.setId(res.getInt("id"));
                habilidade.setId_classe(res.getInt("id_classe"));
                habilidade.setNome(res.getString("nome"));
                habilidade.setCustoDeMana(res.getInt("custo"));
                habilidade.setDuracao(res.getInt("duracao"));
                habilidade.setEfeito(res.getInt("efeito"));
                habilidade.setDescricao(res.getString("descricao"));

                skills.add(habilidade);
            }
            return skills;
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return null;
    }


    private Connection criaConexao() {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");

            conexao = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/rpgenerator",
                    "postgres",
                    "123456");
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return conexao;
    }

    @Override
    public void inserir(Habilidade habilidade) {
        Connection con = criaConexao();

        String sql = "INSERT INTO habilidade (id_classe, nome, tipo, custo, duracao, efeito, descricao) " +
                "VALUES ('" + habilidade.getId_classe() + "'," +
                " '" + habilidade.getNome() + "'," +
                " '" + habilidade.getTipoHabilidade().toString() + "'," +
                " '" + habilidade.getCustoDeMana() + "'," +
                " '" + habilidade.getDuracao() + "'," +
                " '" + habilidade.getEfeito() + "'," +
                " '" + habilidade.getDescricao() + "');";
        try {
            con.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Habilidade habilidade) {
        Connection con = criaConexao();
        String sql = "UPDATE habilidade SET " +
                "nome = ? ," +
                "tipo = ? ," +
                "custo = ? ," +
                "duracao = ? ," +
                "efeito = ? ," +
                "descricao = ? " +
                "WHERE id = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, habilidade.getNome());
            ps.setString(2, habilidade.getTipoHabilidade().toString());
            ps.setInt(3, habilidade.getCustoDeMana());
            ps.setInt(4, habilidade.getDuracao());
            ps.setInt(5, habilidade.getEfeito());
            ps.setString(6, habilidade.getDescricao());
            ps.setInt(7, habilidade.getId());
            ps.execute();
            ps.close();
            con.close();
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        Connection con = criaConexao();
        String sql = "DELETE FROM habilidade WHERE id =" + id;
        try {
            con.prepareStatement(sql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Habilidade> consultar() {
        try {
            List<Habilidade> skills = new ArrayList<>();
            Connection con = criaConexao();
            String sql = "SELECT * FROM habilidade";
            ResultSet res = con.createStatement().executeQuery(sql);

            while (res.next()) {
                Habilidade habilidade = new Habilidade();
                habilidade.setId(res.getInt("id"));
                habilidade.setId_classe(res.getInt("id_classe"));
                habilidade.setNome(res.getString("nome"));
                habilidade.setCustoDeMana(res.getInt("custo"));
                habilidade.setDuracao(res.getInt("duracao"));
                habilidade.setEfeito(res.getInt("efeito"));
                habilidade.setDescricao(res.getString("descricao"));

                skills.add(habilidade);
            }
            return skills;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

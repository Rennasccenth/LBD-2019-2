package rpgenerator.domain.dao.implementa;

import rpgenerator.domain.dao.IPessoaDAO;
import rpgenerator.domain.entidades.Pessoa;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAOImplPostgreSQL implements IPessoaDAO {

    public Pessoa acha_o_cabra(int id) {
        Connection con = criaConexao();

        String sql =
                "SELECT * " +
                "FROM pessoa " +
                "WHERE pessoa.id = " + id + ";";

        try {
            ResultSet res = con.createStatement().executeQuery(sql);
            Pessoa pessoa = new Pessoa();
            pessoa.setId(res.getInt("id"));
            pessoa.setNome(res.getString("nome"));
            pessoa.setVida(res.getInt("vida"));
            pessoa.setMana(res.getInt("mana"));
            pessoa.setNivel(res.getInt("nivel"));
            pessoa.setForca(res.getInt("forca"));
            pessoa.setInteligencia(res.getInt("inteligencia"));
            pessoa.setDestreza(res.getInt("destreza"));
            pessoa.setSabedoria(res.getInt("sabedoria"));
            pessoa.setCarisma(res.getInt("carisma"));
            pessoa.setConstituicao(res.getInt("constituicao"));

            return pessoa;
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
    public void inserir(Pessoa pessoa) {
        Connection con = criaConexao();

        String sql = "INSERT INTO pessoa (nome, vida, mana, nivel, forca, inteligencia, destreza, sabedoria, carisma, constituicao) " +
                "VALUES ('" + pessoa.getNome() +"'," +
                " '" + pessoa.getVida() + "'," +
                " '" + pessoa.getMana() + "'," +
                " '" + pessoa.getNivel() + "'," +
                " '" + pessoa.getForca() + "'," +
                " '" + pessoa.getInteligencia() + "'," +
                " '" + pessoa.getDestreza() + "'," +
                " '" + pessoa.getSabedoria() + "'," +
                " '" + pessoa.getCarisma() + "'," +
                " '" + pessoa.getConstituicao() + "')";
        try{
            con.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        Connection con = criaConexao();
        String sql = "UPDATE pessoa SET " +
                "nome = ? ,"+
                "vida = ? ,"+
                "mana = ? ,"+
                "nivel = ? ,"+
                "forca = ? ,"+
                "inteligencia = ? ,"+
                "destreza = ? ,"+
                "sabedoria = ? ,"+
                "carisma = ? ,"+
                "constituicao = ? ,"+
                " WHERE id = ? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getVida());
            ps.setInt(3, pessoa.getMana());
            ps.setInt(4, pessoa.getNivel());
            ps.setInt(5, pessoa.getForca());
            ps.setInt(6, pessoa.getInteligencia());
            ps.setInt(7, pessoa.getDestreza());
            ps.setInt(8, pessoa.getSabedoria());
            ps.setInt(9, pessoa.getCarisma());
            ps.setInt(10, pessoa.getConstituicao());
            ps.setInt(11, pessoa.getId());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        Connection con = criaConexao();
        String sql = "DELETE FROM pessoa WHERE id ="+id;
        try {
            con.prepareStatement(sql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pessoa> consultar() {
        try{
            List<Pessoa> galera = new ArrayList<Pessoa>();
            Connection con = criaConexao();
            String sql = "SELECT * FROM pessoa";
            ResultSet res = con.createStatement().executeQuery(sql);

            while(res.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setId(res.getInt("id"));
                pessoa.setNome(res.getString("nome"));
                pessoa.setVida(res.getInt("vida"));
                pessoa.setMana(res.getInt("mana"));
                pessoa.setNivel(res.getInt("nivel"));
                pessoa.setForca(res.getInt("forca"));
                pessoa.setInteligencia(res.getInt("inteligencia"));
                pessoa.setDestreza(res.getInt("destreza"));
                pessoa.setSabedoria(res.getInt("sabedoria"));
                pessoa.setCarisma(res.getInt("carisma"));
                pessoa.setConstituicao(res.getInt("constituicao"));

                galera.add(pessoa);
            }
            return galera;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}




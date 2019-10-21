package rpgenerator.domain.dao.implementa;

import rpgenerator.domain.dao.IClasseDAO;
import rpgenerator.domain.entidades.Classe;

import java.sql.*;
import java.util.ArrayList;

public class ClasseDAOImplPostgreSQL implements IClasseDAO {

    public Classe acha_a_classe(int id) {
        Connection con = criaConexao();

        String sql =
                "SELECT * " +
                "FROM classe " +
                "WHERE classe.id = " + id ;

        try {
            ResultSet res = con.createStatement().executeQuery(sql);
            HabilidadeDAOImplPostgreSQL habPSQL = new HabilidadeDAOImplPostgreSQL();
            // Uso isso devido o construtor de classe selecionar o ENUM pela string.
            Classe classe = new Classe(res.getString("enum_classe").toUpperCase());
            classe.setId(res.getInt("id"));
            classe.setVidaPorNivel(res.getInt("vidapornivel"));
            classe.setManaPorNivel(res.getInt("manapornivel"));

            classe.setHabilidades(habPSQL.skills_da_classe(classe.getId()));

            return classe;
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
    public void inserir(Classe classe) {
        Connection con = criaConexao();

        String sql = "INSERT INTO classe (enum_classe , vidapornivel, manapornivel) " +
                "VALUES ('" + classe.getNomeClasse().toString() + "'," +
                " '" + classe.getVidaPorNivel() + "'," +
                " '" + classe.getManaPorNivel() + "');";
        try {
            con.createStatement().execute(sql);
            System.out.println("Classe inserida.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Classe classe) {
        Connection con = criaConexao();
        String sql = "UPDATE classe SET " +
                "enum_classe = ? ," +
                "vidapornivel = ? ," +
                "manapornivel = ? ," +
                "WHERE id = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, classe.getNomeClasse().toString());
            ps.setInt(2, classe.getVidaPorNivel());
            ps.setInt(3, classe.getManaPorNivel());
            ps.setInt(4, classe.getId());
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
        String sql = "DELETE FROM classe WHERE id =" + id;
        try {
            con.prepareStatement(sql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Classe> consultar() {
        try {
            ArrayList<Classe> classes = new ArrayList<>();
            Connection con = criaConexao();
            String sql = "SELECT * FROM classe";
            ResultSet res = con.createStatement().executeQuery(sql);

            while (res.next()) {
                HabilidadeDAOImplPostgreSQL habPSQL = new HabilidadeDAOImplPostgreSQL();
                Classe classe = new Classe(res.getString("enum_classe").toUpperCase());
                classe.setId(res.getInt("id"));
                classe.setVidaPorNivel(res.getInt("vidapornivel"));
                classe.setManaPorNivel(res.getInt("manapornivel"));

                classe.setHabilidades(habPSQL.skills_da_classe(classe.getId()));

                classes.add(classe);
            }
            return classes;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


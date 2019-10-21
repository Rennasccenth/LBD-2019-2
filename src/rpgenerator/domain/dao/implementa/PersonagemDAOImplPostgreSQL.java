package rpgenerator.domain.dao.implementa;

import rpgenerator.domain.dao.IPersonagemDAO;
import rpgenerator.domain.entidades.Item;
import rpgenerator.domain.entidades.Personagem;
import rpgenerator.domain.entidades.itens.AbstractFactoryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAOImplPostgreSQL implements IPersonagemDAO {

    private Connection criaConexao() {
        Connection conexao = null;
        try {
            Class.forName("org.postgresql.Driver");

            conexao = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/rpgenerator",
                    "postgres",
                    "123");
            System.out.println("Conectado ao banco de dados com sucesso!");
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return conexao;
    }

    @Override
    public void inserir(Personagem persn) {
        Connection con = criaConexao();

        String sql = "INSERT INTO personagem (id_pessoa, id_classe, id_inventario, id_armadura, id_arma," +
                "vida_atual, mana_atual, bba, ca) " +
                "VALUES ('" + persn.getPessoa().getId() + "'," +
                " '" + persn.getClasse().getId() + "'," +
                " '" + persn.getInventario().getId() + "'," +
                " '" + persn.getArmadura().getId() + "'," +
                " '" + persn.getArma().getId() + "'," +
                " '" + persn.getVida_atual() + "'," +
                " '" + persn.getMana_atual() + "'," +
                " '" + persn.getBonus_base_de_ataque() + "'," +
                " '" + persn.getClasseArmadura() + "')";
        try {
            con.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Personagem persn) {
        Connection con = criaConexao();
        String sql =
                "UPDATE persn" +
                " SET id_pessoa = ? ," +
                    "id_classe = ? ," +
                    "id_inventario = ? ," +
                    "id_armadura = ? ," +
                    "id_arma = ? ," +
                    "vida_atual = ? ," +
                    "mana_atual = ? ," +
                    "bba = ? ," +
                    "ca = ? " +
                "WHERE id = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, persn.getPessoa().getId());
            ps.setInt(2, persn.getClasse().getId());
            ps.setInt(3, persn.getInventario().getId());
            ps.setInt(4, persn.getArmadura().getId());
            ps.setInt(5, persn.getArma().getId());
            ps.setInt(6, persn.getVida_atual());
            ps.setInt(7, persn.getMana_atual());
            ps.setInt(8, persn.getBonus_base_de_ataque());
            ps.setInt(9, persn.getClasseArmadura());
            ps.setInt(10, persn.getId());
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
        String sql = "DELETE FROM personagem WHERE id =" + id;
        try {
            con.prepareStatement(sql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Personagem> consultar() {
        try {
            List<Personagem> noobs = new ArrayList<>();
            Connection con = criaConexao();
            String sql = "SELECT * FROM personagem";
            ResultSet res = con.createStatement().executeQuery(sql);

            PessoaDAOImplPostgreSQL implPessoa = new PessoaDAOImplPostgreSQL();
            ClasseDAOImplPostgreSQL implClasse = new ClasseDAOImplPostgreSQL();
            InventarioDAOImplPostgreSQL implInv = new InventarioDAOImplPostgreSQL();
            ItemDAOImplPostgreSQL implItem = new ItemDAOImplPostgreSQL();

            while (res.next()) {
                Personagem persn = new Personagem();
                persn.setId(res.getInt("id"));
                persn.setPessoa(implPessoa.acha_o_cabra(res.getInt("id_pessoa")));
                persn.setClasse(implClasse.acha_a_classe(res.getInt("id_classe")));
                persn.setInventario(implInv.acha_os_trecos_do_cabra(res.getInt("id_inventario")));
                persn.setArmadura(implItem.acha_Item(res.getInt("id_armadura")));
                persn.setArma(implItem.acha_Item(res.getInt("id_arma")));
                persn.setVida_atual(res.getInt("vida_atual"));
                persn.setMana_atual(res.getInt("mana_atual"));
                persn.setBonus_base_de_ataque(res.getInt("bba"));
                persn.setClasseArmadura(res.getInt("ca"));

                noobs.add(persn);
            }
            return noobs;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}

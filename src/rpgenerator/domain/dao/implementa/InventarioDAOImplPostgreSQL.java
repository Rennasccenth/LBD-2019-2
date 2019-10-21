package rpgenerator.domain.dao.implementa;

import rpgenerator.domain.dao.IInventarioDAO;
import rpgenerator.domain.entidades.Inventario;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class InventarioDAOImplPostgreSQL implements IInventarioDAO {

    public Inventario acha_os_trecos_do_cabra(int id) {
        Connection con = criaConexao();
        String sql =
                "SELECT * " +
                "FROM inventario " +
                "WHERE inventario.id = " + id ;

        try {
            ItemDAOImplPostgreSQL implPostgreSQL = new ItemDAOImplPostgreSQL();
            ResultSet res = con.createStatement().executeQuery(sql);
            Inventario bag = new Inventario();
            bag.setId(res.getInt("id"));
            bag.setDinheiro(res.getInt("dinheiro"));
            bag.setItens(implPostgreSQL.itens_da_bag(bag.getId()));

            return bag;
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
    public void inserir(Inventario inv) {
        Connection con = criaConexao();
        String sql  = "INSERT INTO inventario (dinheiro) " +
                      "VALUES ('" + inv.getDinheiro() + "');";
        try{
            con.createStatement().execute(sql);
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    @Override
    public void atualizar(Inventario inv) {
        Connection con = criaConexao();
        String sql = "UPDATE inventario SET " +
                "dinheiro = ? where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, inv.getDinheiro());
            ps.setInt(2, inv.getId());
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(int id) {
        Connection con = criaConexao();
        String sql = "DELETE FROM inventario where id = " + id;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Inventario> consultar() {
        try{
            ItemDAOImplPostgreSQL implPostgreSQL = new ItemDAOImplPostgreSQL();
            List<Inventario> lista = new ArrayList<Inventario>();
            Connection con = criaConexao();
            String sql = "SELECT * FROM inventario";
            ResultSet res = con.createStatement().executeQuery(sql);

            while(res.next()){
                Inventario bag = new Inventario();
                bag.setId(res.getInt("id"));
                bag.setDinheiro(res.getInt("dinheiro"));
                bag.setItens(implPostgreSQL.itens_da_bag(bag.getId()));
                lista.add(bag);
            }
            return lista;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package rpgenerator.domain.dao.implementa;

import rpgenerator.domain.dao.IItemDAO;
import rpgenerator.domain.entidades.Item;
import rpgenerator.domain.entidades.itens.AbstractFactoryItem;
import rpgenerator.domain.entidades.itens.CriaFactoryItem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImplPostgreSQL implements IItemDAO {

    public Item acha_Item(int id){
        Connection con = criaConexao();

        String sql =
                "SELECT * " +
                "FROM item " +
                "WHERE item.id =  " + id ;

        try {
            ResultSet res = con.createStatement().executeQuery(sql);
            String tipo = res.getString("tipo");
            AbstractFactoryItem abstrataFactory = CriaFactoryItem.getFactory(tipo);
            Item item = abstrataFactory.createItem();

            item.setId(res.getInt("id"));
            item.setNome(res.getString("nome"));
            item.setPreco(res.getInt("preco"));
            item.setEfeito(res.getInt("efeito"));

            return item;

        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return null;

    }

    public ArrayList<Item> itens_da_bag(int id) {
        ArrayList<Item> itens = new ArrayList<>();
        Connection con = criaConexao();

        String sql =
                "SELECT * " +
                "FROM item inventario item_link " +
                "WHERE item.id = item_link.id_item AND item_link.id_inventario = "+ id;

        try {
            ResultSet res = con.createStatement().executeQuery(sql);
            while(res.next()) {
                String tipo = res.getString("tipo");
                AbstractFactoryItem abstrataFactory = CriaFactoryItem.getFactory(tipo);
                Item item = abstrataFactory.createItem();

                item.setId(res.getInt("id"));
                item.setNome(res.getString("nome"));
                item.setPreco(res.getInt("preco"));
                item.setEfeito(res.getInt("efeito"));

                itens.add(item);
            }
            return itens;
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
    public void inserir(Item item) {
        Connection con = criaConexao();

        String sql = "INSERT INTO item (nome, tipo, preco, efeito) " +
                "VALUES ('" + item.getNome() + "'," +
                " '" + item.getTipo().toString() + "'," +
                " '" + item.getPreco() + "'," +
                " '" + item.getEfeito() + "')";
        try {
            con.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Item item) {
        Connection con = criaConexao();
        String sql = "UPDATE item SET " +
                "nome = ? ," +
                "tipo = ? ," +
                "preco = ? ," +
                "efeito = ? ," +
                "WHERE id = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getNome());
            ps.setInt(2, item.getTipo().getValorItem());
            ps.setInt(3, item.getPreco());
            ps.setInt(4, item.getEfeito());
            ps.setInt(5, item.getId());
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
        String sql = "DELETE FROM item WHERE id =" + id;
        try {
            con.prepareStatement(sql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> consultar() {
        try {
            List<Item> lista = new ArrayList<Item>();
            Connection con = criaConexao();
            String sql = "SELECT * FROM item";
            ResultSet res = con.createStatement().executeQuery(sql);

            while (res.next()) {
                String tipo = res.getString("tipo");
                AbstractFactoryItem abstrataFactory = CriaFactoryItem.getFactory(tipo);
                Item item = abstrataFactory.createItem();

                item.setId(res.getInt("id"));
                item.setNome(res.getString("nome"));
                item.setPreco(res.getInt("preco"));
                item.setEfeito(res.getInt("efeito"));

                lista.add(item);
            }
            return lista;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
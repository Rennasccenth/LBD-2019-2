package rpgenerator.domain.entidades;

import java.util.ArrayList;

public class

Inventario {
    private int id;
    private int dinheiro;
    private ArrayList<Item> itens;

    public Inventario(){
        this.dinheiro = 0;
        this.itens = new ArrayList<Item>();
    }

    public void adiciona_item(Item item){
        this.itens.add(item);
    } // OK

    public void mostra_Inventario(){
        for (Item i : this.itens) {
            if (i != null) {
                System.out.println(
                        "ID " + i.getId() +
                                " Tipo: " + i.getTipo() +
                                " Bonus: +" + i.getEfeito() +
                                " Nome: " + i.getNome() +
                                " Preço: " + i.getPreco());
            }
            else{
                System.out.println("Não há itens no inventário.");
            }
        }
    } // OK

    public Item procura_item(int id){
        for (Item i : this.itens) {
            if(i.getId() == id)
                return i;
        }
        System.out.println("Não há esse item no inventario.");
        return null;
    } // OK

    public Item remove_item(int id){
        Item i = procura_item(id);
        if (i != null) {
            this.itens.remove(i);
            return i;
        }
        System.out.println("Não foi possível efetuar a remoção.");
        return null;
    } // OK

    public int vende_item(int id){
        Item i = procura_item(id);
        if(i != null){
            this.dinheiro += remove_item(i.getId()).getPreco();
            System.out.println("O item "+i.getNome()+" foi vendido por "+i.getPreco()+" moedas de Ouro.");
            return 1;
        }
        System.out.println("Item não encontrado.");
        return 0;
    } // OK


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
}
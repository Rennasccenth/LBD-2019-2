package rpgenerator.domain.entidades.itens;

import rpgenerator.domain.entidades.Enums.ItemEnum;
import rpgenerator.domain.entidades.Item;
import rpgenerator.domain.entidades.Personagem;

public class Pocaomana extends Item {

    public Pocaomana(){
        setTipo(ItemEnum.POCAO_MANA);
    }

    //Retorna uma instancia atualizada de personagem.

    public Personagem utilizar(Personagem persn) {
        if(persn.getMana_atual() == persn.getPessoa().getMana()){
            return persn;
        }
        persn.getInventario().remove_item(this.getId());
        return update_Status_POCAOMANA(persn);
    } // OK

    private Personagem update_Status_POCAOMANA(Personagem persn){
        int mana_curada = persn.getMana_atual() + this.getEfeito();
        if (mana_curada > persn.getPessoa().getMana())
            mana_curada = persn.getPessoa().getMana(); // A mana curada não pode passar da mana máxima.
        persn.setMana_atual(mana_curada);
        return persn;
    } // OK

    @Override
    public Item createItem() {
        return new Pocaomana();
    }
}

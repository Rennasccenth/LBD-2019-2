package rpgenerator.domain.entidades.itens;

import rpgenerator.domain.entidades.Enums.ItemEnum;
import rpgenerator.domain.entidades.Item;
import rpgenerator.domain.entidades.Personagem;

public class Pocaohp extends Item {

    public Pocaohp(){
        setTipo(ItemEnum.POCAO_HP);
    }

    //Retorna uma instancia atualizada de personagem.

    public Personagem utilizar(Personagem persn) {
        if(persn.getVida_atual() == persn.getPessoa().getVida()){
            return persn;
        }
        persn.getInventario().remove_item(this.getId());
        return update_Status_POCAOHP(persn);
    } // OK

    private Personagem update_Status_POCAOHP(Personagem persn){
        int vida_curada = persn.getVida_atual() + this.getEfeito();
        if (vida_curada > persn.getPessoa().getVida())
            vida_curada = persn.getPessoa().getVida(); // A vida curada não pode passar da vida máxima.
        persn.setVida_atual(vida_curada);
        return persn;
    } // OK

    @Override
    public Item createItem() {
        return new Pocaohp();
    }
}

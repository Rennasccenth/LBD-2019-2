package rpgenerator.domain.entidades.itens;

import rpgenerator.domain.entidades.Enums.ItemEnum;
import rpgenerator.domain.entidades.Item;
import rpgenerator.domain.entidades.Personagem;

public class Armadura extends Item implements Cloneable {
    private Boolean ativo;

    @Override
    public Armadura clone() throws CloneNotSupportedException{
        return (Armadura) super.clone();
    }

    public Armadura(){
        setTipo(ItemEnum.ARMADURA);
    }

    //Retorna uma instancia atualizada de personagem.

    public Personagem utilizar(Personagem persn) {
        if (persn.getEquipado().equals(Boolean.FALSE)){ // Se estiver sem armadura equipada.
            persn.getInventario().remove_item(this.getId());
            return update_Status_ARMADURA(persn);
        }
        else if (persn.getEquipado().equals(Boolean.TRUE)){
            persn.getInventario().adiciona_item(persn.getArmadura());
            persn.getInventario().remove_item(this.getId());
            return update_Status_ARMADURA(persn);
        }
        return persn;
    } // OK

    private Personagem update_Status_ARMADURA(Personagem persn){
        try {
            this.ativar();
            Armadura armadura = this.clone();
            persn.setArmadura(armadura);
            persn.setEquipado(Boolean.TRUE);
            persn.setClasseArmadura(this.getEfeito() + ((10 + persn.getPessoa().getNivel()) / 2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return persn;
    } // OK

    public void desativar(){
        this.ativo = Boolean.FALSE;
    } // OK

    public void ativar(){
        this.ativo = Boolean.TRUE;
    } // OK

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public Item createItem() {
        return new Armadura();
    }
}


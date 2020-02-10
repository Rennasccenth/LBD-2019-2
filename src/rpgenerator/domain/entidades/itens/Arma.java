package rpgenerator.domain.entidades.itens;

import rpgenerator.domain.entidades.Enums.ItemEnum;
import rpgenerator.domain.entidades.Item;
import rpgenerator.domain.entidades.Personagem;

public class Arma extends Item implements Cloneable {
    private Boolean ativo;

    @Override
    public Arma clone() throws CloneNotSupportedException{
        return (Arma) super.clone();
    }

    public Arma(){
        setTipo(ItemEnum.ARMA);
    }

    //Retorna uma instancia atualizada de personagem.
    //Adicionar erro critico

    public Personagem utilizar(Personagem persn) {
        if (persn.getArmado().equals(Boolean.FALSE)){
            persn.getInventario().remove_item(this.getId());
            return update_Status_ATK(persn);
        }
        // Se o personagem estiver armado então desequipamos a Arma equipada (Fazemos ela voltar pro inventario)
        // e Equipamos a desse objeto (Removendo-a do inventario)
        else if (persn.getArmado().equals(Boolean.TRUE)){
            persn.getInventario().adiciona_item(persn.getArma());
            persn.getInventario().remove_item(this.getId());
            return update_Status_ATK(persn);
        }
        return persn;
    } // OK

    private Personagem update_Status_ATK(Personagem persn){
        try {
            this.ativar();
            Arma arma = this.clone();
            persn.setArma(arma);
            persn.setArmado(Boolean.TRUE);
            persn.setDano_min(this.getEfeito());
            persn.setDano_max(this.getEfeito() + persn.getPessoa().getNivel());
            persn.setBonus_base_de_ataque(this.getEfeito() + persn.getPessoa().getNivel() );
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return persn;
    } // OK

    public void desequipar(){
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
        return new Arma();
    }
}

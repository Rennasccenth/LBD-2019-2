package rpgenerator.domain.entidades.Enums;

public enum ItemEnum {

    ARMA(1),
    ARMADURA(2),
    POCAO_HP(3),
    POCAO_MANA(4);

    public int valorItem;

    ItemEnum(int valor){
        valorItem = valor;
    }

    public int getValorItem() {
        return valorItem;
    }

    public void setValorItem(int valorItem) {
        this.valorItem = valorItem;
    }
}

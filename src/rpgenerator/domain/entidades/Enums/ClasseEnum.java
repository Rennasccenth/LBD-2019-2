package rpgenerator.domain.entidades.Enums;

public enum ClasseEnum {
    GUERREIRO(1),
    MAGO(2),
    ARQUEIRO(3),
    LADINO(4),
    SACERDOTE(5),
    BARBARO(6),
    PISTOLEIRO(7);

    private int valorClasse;

    ClasseEnum(int valor){
        valorClasse = valor;
    }

    public int getValorClasse() {
        return valorClasse;
    }

}

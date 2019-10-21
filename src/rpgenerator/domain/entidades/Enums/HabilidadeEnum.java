package rpgenerator.domain.entidades.Enums;

public enum HabilidadeEnum {
    FOGO(1),
    AGUA(2),
    TERRA(3),
    AR(4),
    SAGRADO(5),
    PROFANO(6),
    ARCANO(7);

    private int valorHabilidade;

    HabilidadeEnum(int valor){
        valorHabilidade = valor;
    }

    public int getValorHabilidade() {
        return valorHabilidade;
    }
}

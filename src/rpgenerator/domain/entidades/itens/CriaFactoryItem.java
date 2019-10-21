package rpgenerator.domain.entidades.itens;

public class CriaFactoryItem {

    private static AbstractFactoryItem abstrataFactory = null;

    public static AbstractFactoryItem getFactory(String tipo){
        switch (tipo.toUpperCase()) {
            case "ARMA":
                abstrataFactory = new Arma();
                break;
            case "ARMADURA":
                abstrataFactory = new Armadura();
                break;
            case "POCAO_HP":
                abstrataFactory = new Pocaohp();
                break;
            case "POCAO_MANA":
                abstrataFactory = new Pocaomana();
                break;
        }
        return abstrataFactory;
    }
}

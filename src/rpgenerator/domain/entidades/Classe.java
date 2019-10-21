package rpgenerator.domain.entidades;

import rpgenerator.domain.entidades.Enums.ClasseEnum;

import java.util.ArrayList;
import java.util.List;

public class Classe {

    private int id;
    private ClasseEnum nomeClasse;
    private int vidaPorNivel;
    private int manaPorNivel;
    private ArrayList<Habilidade> habilidades;

    public Classe(String classe){
        this.nomeClasse = ClasseEnum.valueOf(classe.toUpperCase());
        this.habilidades = new ArrayList<Habilidade>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClasseEnum getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(ClasseEnum nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public int getVidaPorNivel() {
        return vidaPorNivel;
    }

    public void setVidaPorNivel(int vidaPorNivel) {
        this.vidaPorNivel = vidaPorNivel;
    }

    public int getManaPorNivel() {
        return manaPorNivel;
    }

    public void setManaPorNivel(int manaPorNivel) {
        this.manaPorNivel = manaPorNivel;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }
}

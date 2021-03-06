package rpgenerator.domain.entidades;


import java.util.Scanner;

public class Pessoa {

    private int id;
    private String nome;
    private int vida;
    private int mana;
    private int nivel;

    private int forca;
    private int inteligencia;
    private int destreza;
    private int sabedoria;
    private int carisma;
    private int constituicao;

    public Pessoa preenchePessoa(){
        Pessoa p = new Pessoa();
        Scanner s = new Scanner(System.in);
        System.out.println("Nome: ");
        p.setNome(s.nextLine());
        System.out.println("Vida: ");
        p.setVida(s.nextInt());
        System.out.println("Mana: ");
        p.setMana(s.nextInt());
        System.out.println("Nível: ");
        p.setNivel(s.nextInt());

        System.out.println("Força: ");
        p.setForca(s.nextInt());
        System.out.println("Inteligência: ");
        p.setInteligencia(s.nextInt());
        System.out.println("Destreza: ");
        p.setDestreza(s.nextInt());
        System.out.println("Sabedoria: ");
        p.setSabedoria(s.nextInt());
        System.out.println("Carisma: ");
        p.setCarisma(s.nextInt());
        System.out.println("Constituição: ");
        p.setConstituicao(s.nextInt());

        return p;
    }

    public Pessoa(){
        this.nivel = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }
}

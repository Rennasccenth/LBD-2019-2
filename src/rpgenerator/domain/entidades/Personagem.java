package rpgenerator.domain.entidades;

import rpgenerator.domain.entidades.itens.Arma;
import rpgenerator.domain.entidades.itens.Armadura;

import java.util.Random;

public class Personagem {
    private int id;
    private int vida_atual;
    private int mana_atual;


    private Inventario inventario;
    private Pessoa pessoa;
    private Classe classe;

    private int classeArmadura;

    private int dano_min;
    private int dano_max;
    private int bonus_base_de_ataque;

    private Boolean armado;
    private Boolean equipado;
    private Item arma;
    private Item armadura;

    public Personagem(){
        this.inventario = new Inventario();
        this.pessoa = new Pessoa();
        this.armado = Boolean.FALSE;
        this.equipado = Boolean.FALSE;
    }
    // Retornará uma nova instância atualizada do personagem que foi atacado.
    public Personagem ataca(Personagem inimigo){

        int jogada = this.bonus_base_de_ataque + rolagem_d20();

        if(jogada == 20){ // Acerto Crítico.
            inimigo.setVida_atual(inimigo.getVida_atual() - rolagem_dano() * 2 );
            return inimigo;
        }

        else if(jogada > inimigo.getClasseArmadura()){
            inimigo.setVida_atual(inimigo.getVida_atual() - rolagem_dano() );
            return inimigo;
        }

        return inimigo;
    }
    // Retornará uma nova instância atualizada do personagem que foi atacado pela habilidade.

    public Personagem usa_habilidade(Personagem inimigo){
        return inimigo;
    }

    private int rolagem_d20(){
        Random rolagem = new Random();
        return (int) rolagem.ints(1,21).findFirst().getAsInt();
    }

    private int rolagem_d12(){
        Random rolagem = new Random();
        return (int) rolagem.ints(1,13).findFirst().getAsInt();
    }

    private int rolagem_d10() {
        Random rolagem = new Random();
        return (int) rolagem.ints(1, 11).findFirst().getAsInt();
    }

    private int rolagem_d8() {
        Random rolagem = new Random();
        return (int) rolagem.ints(1, 9).findFirst().getAsInt();
    }

    private int rolagem_d6(){
        Random rolagem = new Random();
        return (int) rolagem.ints(1,7).findFirst().getAsInt();
    }

    private int rolagem_d4(){
        Random rolagem = new Random();
        return (int) rolagem.ints(1,5).findFirst().getAsInt();
    }

    private int rolagem_d2(){
        Random rolagem = new Random();
        return (int) rolagem.ints(1,3).findFirst().getAsInt();
    }

    private int rolagem_dano(){
        Random rolagem = new Random();
        return (rolagem.nextInt((this.dano_max +1) - this.dano_min) ) + this.dano_min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVida_atual() {
        return vida_atual;
    }

    public void setVida_atual(int vida_atual) {
        this.vida_atual = vida_atual;
    }

    public int getMana_atual() {
        return mana_atual;
    }

    public void setMana_atual(int mana_atual) {
        this.mana_atual = mana_atual;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public int getDano_min() {
        return dano_min;
    }

    public void setDano_min(int dano_min) {
        this.dano_min = dano_min;
    }

    public int getDano_max() {
        return dano_max;
    }

    public void setDano_max(int dano_max) {
        this.dano_max = dano_max;
    }

    public int getBonus_base_de_ataque() {
        return bonus_base_de_ataque;
    }

    public void setBonus_base_de_ataque(int bonus_base_de_ataque) {
        this.bonus_base_de_ataque = bonus_base_de_ataque;
    }

    public Boolean getArmado() {
        return armado;
    }

    public void setArmado(Boolean armado) {
        this.armado = armado;
    }

    public Boolean getEquipado() {
        return equipado;
    }

    public void setEquipado(Boolean equipado) {
        this.equipado = equipado;
    }

    public Item getArma() {
        return arma;
    }

    public void setArma(Item arma) {
        this.arma = arma;
    }

    public Item getArmadura() {
        return armadura;
    }

    public void setArmadura(Item armadura) {
        this.armadura = armadura;
    }
}
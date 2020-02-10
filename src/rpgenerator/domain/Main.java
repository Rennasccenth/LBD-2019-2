package rpgenerator.domain;

import rpgenerator.domain.dao.*;
import rpgenerator.domain.dao.implementa.*;
import rpgenerator.domain.entidades.*;
import rpgenerator.domain.entidades.Enums.ClasseEnum;
import rpgenerator.domain.entidades.Enums.HabilidadeEnum;
import rpgenerator.domain.entidades.itens.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IPessoaDAO bancoPessoa = new PessoaDAOImplPostgreSQL();
        IClasseDAO bancoClasse = new ClasseDAOImplPostgreSQL();
        IItemDAO bancoItem = new ItemDAOImplPostgreSQL();
        IPersonagemDAO bancoPersonagem = new PersonagemDAOImplPostgreSQL();
        IInventarioDAO bancoInventario = new InventarioDAOImplPostgreSQL();
        IHabilidadeDAO bancoHabilidade = new HabilidadeDAOImplPostgreSQL();
        Menu m = new Menu();
        Scanner t = new Scanner(System.in);


        int opcao = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1 - Pessoas");
            System.out.println("2 - Habilidades");
            System.out.println("3 - Classes");
            System.out.println("4 - Items");
            System.out.println("5 - Inventarios");
            System.out.println("6 - Personagens");
            System.out.println("7 - Sair");
            System.out.println("Digite a opção:");
            opcao = t.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("    PESSOAS");
                    m.mostrarMenu();

                    switch(opcao){
                        case 1: Pessoa p = new Pessoa();
                                bancoPessoa.inserir(p.preenchePessoa());

                        case 2: Scanner t = new Scanner(System.in);
                                bancoPessoa.remover(t.nextInt());
                    }

                    break;
                case 2:
                    System.out.println("    HABILIDADES");
                    m.mostrarMenu();
                    break;
                case 3:
                    System.out.println("    CLASSES");
                    m.mostrarMenu();
                    break;
                case 4:
                    System.out.println("    ITEM");
                    m.mostrarMenu();
                    break;
                case 5:
                    System.out.println("    INVENTÁRIO");
                    m.mostrarMenu();
                    break;
                case 6:
                    System.out.println("    PERSONAGENS");
                    m.mostrarMenu();
                    break;
                case 7:
                    System.out.println("    SAINDO");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcao != 5);




    }
}
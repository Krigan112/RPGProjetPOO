package RPG.models;

import RPG.views.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character
{

    private ArrayList<Spell> spellList = new ArrayList<>();

    public Player(){
        Spell fireBall = new Spell("Boule de feu", 20, 1);
        this.healthPoints = 100;
        this.spellList.add(fireBall);
    }

    public void action(Player player, Monster monster) {
        Scanner in = new Scanner(System.in);
        System.out.println("Vous: "+Utils.healthGauge(player));
        System.out.println("Adversaire: "+Utils.healthGauge(monster));
        Utils.textLine("Que faites vous?");
        int choice = 0;
        while(choice == 0) {
            System.out.println("1. Attaque\n2. Magie\n3. Défense");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Vous attaquez.");
                    attack(player, monster);
                    break;
                case 2:
//                    Utils.textLine("Vous lancez un sort.");
//                    spells(player, monster);
                    Utils.textLine("Vous n'avez pas de sorts.");
                    choice = 0;
                    break;
                case 3:
                    Utils.textLine("Vous tentez d'esquiver.");
                    break;
                default:
                    Utils.textLine("Veuillez choisir un chiffre de la liste.");
                    choice = 0;
            }
        }
    }

//    private void spells(Player player, Monster monster) {
//        Utils.textLine("Choisissez un sort :");
//        spellList.forEach(spell -> {
//            System.out.println("");
//        });
//    }

    private void attack(Player player, Monster monster) {
        monster.looseHealth(player.getDamages()-monster.getDefense());
        System.out.println(monster.getName()+" a perdu "+(player.getDamages()-monster.getDefense())+" points de vie. Il lui reste "+monster.getHealthPoints()+"PV");
    }
}

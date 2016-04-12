package RPG.models;

import RPG.views.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character
{

    private ArrayList<Spell> spellList = new ArrayList<>();

    public Player(){
        this.healthPoints = 100;
    }

    public ArrayList<Spell> getSpells(){return spellList;}

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
                    choice = spells(player, monster);
//                    Utils.textLine("Vous n'avez pas de sorts.");
//                    choice = 0;
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

    public int spells(Player player, Monster monster) {
        Scanner inputSpell = new Scanner(System.in);
        if (player.spellList.size() == 0) {
            Utils.textLine("Vous n'avez pas de sorts.");
            return 0;
        }
        System.out.println("Choisissez un sort :");
        for (int i = 0; i < player.spellList.size(); i++) {
            System.out.println(i + 1 + ". " + player.spellList.get(i).getName() + " dégâts: " + player.spellList.get(i).getDamages() + ", utilisations restantes : " + player.spellList.get(i).getAmmo() + ".");
        }
        System.out.println(player.spellList.size() + 1 + ". Retour");

        int choice = inputSpell.nextInt();

        if (choice == player.spellList.size() + 1) {
            System.out.println("Lancement de sort annulé.");
            return 0;
        } else if(choice <= player.spellList.size() && choice >= 0) {
            cast(player, monster, choice - 1);
            return 2;
        } else{
            System.out.println("Veuillez choisir un chiffre de la liste.");
            spells(player, monster);
            return 2;
        }
    }

    public void cast(Player player, Monster monster, int spell) {
        if (spellList.get(spell).getAmmo() > 0) {
            monster.looseHealth(spellList.get(spell).getDamages());
            spellList.get(spell).setAmmo(spellList.get(spell).getAmmo() - 1);
            System.out.println("Vous avez infligé "+spellList.get(spell).getDamages()+" points de dégâts à "+monster.getName()+".");
        }else{
            System.out.println("Vous n'avez plus de munitions pour ce sort.");
            player.spells(player, monster);
        }
    }

    private void attack(Player player, Monster monster) {
        int damages = monster.looseHealth(player.getDamages()-monster.getDefense());
        System.out.println(monster.getName()+" a perdu "+(damages-monster.getDefense())+" points de vie. Il lui reste "+monster.getHealthPoints()+"PV");
    }

    public void addSpell(String name, int damages, int ammo){
        Spell newSpell = new Spell(name, damages, ammo);
        this.spellList.add(newSpell);
    }
}

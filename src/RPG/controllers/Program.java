package RPG.controllers;

import RPG.models.Monster;
import RPG.models.Player;
import RPG.views.Utils;

import java.util.Objects;
import java.util.Scanner;

public class Program
{
    public static void main(String[] args){
        RPG.views.Menu.run();
    }

    public static boolean fight(Player player, Monster monster){
        while(player.getHealthPoints()!=0 && monster.getHealthPoints()!=0){

            if(!player.action(player, monster)){
                return false;
            }

            if(monster.getHealthPoints()<=0){
                Utils.textLine("Vous avez tué "+monster.getName()+".");
                return true;
            }

            monster.attack(player, monster);

            if(player.getHealthPoints()<=0){
                Utils.textLine("Vous êtes mort.");
                RPG.views.Menu.run();
            }
        }
        return false;
    }

    public static void bonfire(Player player, String savepoint) {
        player.setHealthPoints(100);
        player.reloadSpells();
        Scanner inputBonfire = new Scanner(System.in);
        String choice = "0";
        while(Objects.equals(choice, "0")){
            System.out.println("Feu de camp:\n1. Inventaire\n2. Sauvegarder\n3. Quitter\n4. Retour");
            choice = inputBonfire.next();
            switch(choice){
                case "1":
                    Utils.inventory(player);
                    choice = "0";
                    break;
                case "2":
                    player.setSavePoint(savepoint);
                    Options.save(player);
                    break;
                case "3":
                    System.out.println("Êtes-vous sûr de vouloir quitter le jeu? Toute progression non sauvegardée sera perdue. o/n");
                    String secChoice = inputBonfire.next();
                    if(Objects.equals(secChoice, "o")){
                        Options.exit();
                    }else if(Objects.equals(secChoice, "n")){
                        choice = "0";
                        break;
                    }else{
                        System.out.println("Veuillez entrer \"o\" ou \"n\"");
                    }

                case "4":
                    System.out.println("Êtes-vous sûr de vouloir partir du feu? o/n");
                    secChoice = inputBonfire.next();
                    if(Objects.equals(secChoice, "o")){
                        break;
                    }else if(Objects.equals(secChoice, "n")){
                        choice = "0";
                        break;
                    }else{
                        System.out.println("Veuillez entrer \"o\" ou \"n\"");
                    }
                    break;
            }
        }
    }
}

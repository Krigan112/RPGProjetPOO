package RPG.views;

import RPG.models.Monster;
import RPG.models.Player;
import RPG.models.Character;

import java.util.Objects;
import java.util.Scanner;

public class Utils
{
    public static void chooseYourName(Player player, Scanner in) {
        String choice = "0";
        while(Objects.equals(choice, "0")) {
            System.out.println("Entrez le nom de votre personnage : ");
            player.setName(in.nextLine());
            System.out.println("Vous vous appelez donc \"" + player.getName() + "\" ? (o/n)");
            if (Objects.equals(in.next(), "o")) {
                break;
            } else if (Objects.equals(in.next(), "n")) {
                choice = "0";
            } else {
                System.out.println("Veuillez entrer \"o\" ou \"n\"");
            }
        }
    }

    public static void textLine(String output){
        Scanner text = new Scanner(System.in);
        System.out.println(output);
        text.nextLine();
    }

    public static String spells(Player player, Monster monster) {
        Scanner inputSpell = new Scanner(System.in);
        if (player.getSpells().size() == 0) {
            Utils.textLine("Vous n'avez pas de sorts.");
            return "0";
        }
        System.out.println("Choisissez un sort :");
        for (int i = 0; i < player.getSpells().size(); i++) {
            System.out.println(i + 1 + ". " + player.getSpells().get(i).getName() + " dégâts: " + player.getSpells().get(i).getDamages() + ", utilisations restantes : " + player.getSpells().get(i).getAmmo() + ".");
        }
        System.out.println(player.getSpells().size() + 1 + ". Retour");

        int choice = inputSpell.nextInt();

        if (choice == player.getSpells().size() + 1) {
            System.out.println("Lancement de sort annulé.");
            return "0";
        } else if(choice <= player.getSpells().size() && choice >= 0) {
            player.cast(monster, choice - 1);
            return "2";
        } else{
            System.out.println("Veuillez choisir un chiffre de la liste.");
            spells(player, monster);
            return "0";
        }
    }

    public static String inventory(Player player) {
        Scanner inputInventory = new Scanner(System.in);
        if (player.getInventory().size() == 0) {
            System.out.println("Vous n'avez pas d'objets.");
            return "0";
        }
        System.out.println("Choisissez un objet à équiper/utiliser :");
        for (int i = 0; i < player.getInventory().size(); i++) {
            System.out.println(i + 1 + ". " + player.getInventory().get(i).getName());
        }
        System.out.println(player.getInventory().size() + 1 + ". Retour");

        int choice = inputInventory.nextInt();

        if (choice == player.getInventory().size() + 1) {
            return "0";
        } else if(choice <= player.getInventory().size() && choice >= 0) {
            player.equip(choice - 1);
            return "2";
        } else{
            System.out.println("Veuillez choisir un chiffre de la liste.");
            inventory(player);
            return "2";
        }
    }

    public static String healthGauge(Character character){
        String gauge = "";
        for(int i=1; i<=character.getHealthPoints(); i++){
            gauge = gauge+"=";
        }
        return ("["+gauge+"] ("+character.getHealthPoints()+")");
    }
}

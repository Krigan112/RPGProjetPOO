package RPG.views;

import RPG.controllers.Program;
import RPG.models.*;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    /*
    The game works with switches in whiles. The user choose a number in the list, his choice is stocked
    in the variable choice, and when choice = "0", it means that there is an error, and the while redo the code.
    The errors appends when for example, the user wants to open his inventory, but he don't have any items.
    If we want the story to pass the choices, just do a break in the switch, and let the choice's value to
    another value that "0", like the user's choice.
     */

    public static void newGame(Player player) {
        Scanner in = new Scanner(System.in);

        //Declarations of armors(name, defense)
        Armor noArmor = new Armor("", 0);
        Armor lightArmor = new Armor("Armure légère", 5);
        Armor steelArmor = new Armor("Armure en acier", 30);

        //Declarations of weapons(name, damagesMax, damagesMin)
        Weapon noWeapon = new Weapon("", 0, 0);
        Weapon fists = new Weapon("Poings", 1, 3);
        Weapon dagger = new Weapon("Dague", 2, 5);
        Weapon broadsword = new Weapon("Espadon", 20, 30);

        //Declarations of potions(name, type, ammount)
        Potion tinyHealthPotion = new Potion("Petite potion de soin", "health", 30);

        //Declarations of monsters(name, healthPoints, speed, weapon, armor)
        Monster skinned = new Monster("L'écorché", 10, 50, noWeapon, noArmor);
        Monster livingArmor = new Monster("L'armure vivante", 100, 2, broadsword, steelArmor);

        if(Objects.equals(player.getSavePoint(), "begin")) {
            String choice = "0";
            player.setWeapon(fists);
            player.setArmor(noArmor);

            Utils.textLine("Vous vous réveillez dans une cellule dégoûtante...");
            Utils.textLine("Vous vous baissez, et appercevez un objet brillant par terre : La clé!");
            Utils.textLine("Vous ouvrez la porte, et avancez dans un couloir sombre. Un bruit de pas lourd au loin vous fait frissonner.");
            Utils.textLine("Vous rencontrez un homme vêtu d'un pagne il est de dos. Que faites vous?");
            while (Objects.equals(choice, "0")) {
                System.out.println("1. Vous vous approchez pour lui parler\n2. Vous le frappez dans le dos\n3. Vous passez votre chemin");
                choice = in.next();
                switch (choice) {
                    case "1":
                        Utils.textLine("Il se retourne et vous voyez son visage décomposé. Cet homme est visiblement déjà mort.");
                        Utils.textLine("Il semble avoir perdu la raison et commence à agiter ses bras dans votre direction.");
                        Utils.textLine("Vous prenez un coup au visage et reculez. Vous avez perdu 5 points de vie.");
                        player.looseHealth(5);
                        break;
                    case "2":
                        Utils.textLine("Vous levez les poings et le frappez violement dans le dos. Vous lui infligez 5 points de dégâts.");
                        Utils.textLine("Il se retourne et vous voyez son visage en putréfaction.");
                        Utils.textLine("L'homme déjà mal en point se relève et vous attaque.");
                        skinned.looseHealth(5);
                        break;
                    case "3":
                        Utils.textLine("Vous passez à côté de l'homme sans rien dire.");
                        Utils.textLine("L'homme vous remarque et se retourne, son visage écorché vous apparaît.");
                        Utils.textLine("Il crie quelque chose d'incompréhensible et se rue vers vous.");
                        break;
                    default:
                        System.out.println("Veuillez choisir un chiffre de la liste.");
                        choice = "0";
                }
                if (!Program.fight(player, skinned)) {
                    choice = "0";
                }
            }

            Utils.textLine("Après avoir tué l'écorché, vous continuez votre chemin.");
            choice = "0";
            boolean firstPast = true;
            while (Objects.equals(choice, "0")) {
                System.out.println("Trois chemins s'offrent à vous :");
                if (firstPast) {
                    System.out.println("1. Une cellule à gauche\n2. Tout droit dans le couloir\n3. Une porte à droite");
                } else {
                    System.out.println("1. La cellule à gauche\n2. Tout droit dans le couloir\n3. La porte à droite");
                }
                choice = in.next();
                switch (choice) {
                    case "1":
                        if (firstPast) {
                            Utils.textLine("Dans la cellule, vous trouvez une dague " + dagger.getDamagesAsString() + ". Vous retournez ensuite vers le couloir.");
                            player.addItem(dagger);
                            firstPast = false;
                            choice = "0";
                            break;
                        } else {
                            Utils.textLine("Vous êtes déjà passé par ici...");
                            choice = "0";
                            break;
                        }
                    case "2":
                        Utils.textLine("Vous tombez face à une armure vivante de deux mètres de haut.");
                        Utils.textLine("L'armure lève son espadon et l'abat sur vous.");
                        if (!Program.fight(player, livingArmor)) {
                            choice = "0";
                            break;
                        }
                        Utils.textLine("Vous avez vaincu l'armure vivante et avez récupéré son espadon " + broadsword.getDamagesAsString() + " !");
                        player.addItem(broadsword);
                        Utils.textLine("Vous vous dirigez ensuite vers la porte à droite, qui vous mène à une cour avec un feu de camp au milieu..");
                        break;
                    case "3":
                        Utils.textLine("La porte à droite vous mène à une cour avec un feu de camp au milieu.");
                        break;
                    default:
                        System.out.println("Veuillez choisir un chiffre de la liste");
                        choice = "0";
                }
            }
            player.setSavePoint("cour");
        }if(Objects.equals(player.getSavePoint(), "cour")) {
            Utils.textLine("Vous vous approchez du feu de camp, et l'allumez.");
            Utils.textLine("La chaleur vous réconforte, et vous êtes soigné");
            Program.bonfire(player, "cour");
            System.out.println("Vous pouvez partir par trois chemins :\n1. Gauche dans les égouts\n2. Droite vers les couloirs\n3. Tout droit vers une énorme porte");
            String choice = "0";
            while (Objects.equals(choice, "0")) {
                choice = in.next();
                switch (choice) {
                    case "1":
                        RPG.views.Sewer.sewer();
                        break;
                    case "2":
                        RPG.views.Hall.hall();
                        break;
                    case "3":
                        RPG.views.WasteLands.wasteLands(player);
                        break;
                    default:
                        System.out.println("Veuillez choisir un chiffre de la liste");
                        choice = "0";
                        break;
                }
            }
        }
    }
}

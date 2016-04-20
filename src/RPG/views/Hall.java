package RPG.views;

import RPG.controllers.Program;
import RPG.models.*;

import java.util.Objects;
import java.util.Scanner;

public class Hall {
    public static void hall(Player player){

        Scanner in = new Scanner(System.in);

        //Declarations of armors(name, defense)
        Armor noArmor = new Armor("", 0);
        Armor lightArmor = new Armor("Armure légère", 4);
        Armor steelArmor = new Armor("Armure en acier", 30);

        //Declarations of weapons(name, damagesMax, damagesMin)
        Weapon noWeapon = new Weapon("", 0, 0);
        Weapon fists = new Weapon("Poings", 1, 3);
        Weapon dagger = new Weapon("Dague", 2, 5);
        Weapon broadsword = new Weapon("Espadon", 20, 30);

        //Declarations of potions(name, type, ammount)
        Potion tinyHealthPotion = new Potion("Petite potion de soin", "health", 30);

        //Declarations of monsters(name, healthPoints, speed, weapon, armor)
        Monster skinned1 = new Monster("L'écorché", 10, 50, dagger, noArmor);
        Monster skinned2 = new Monster("L'écorché", 10, 50, dagger, noArmor);
        Monster skinned3 = new Monster("L'écorché", 10, 50, dagger, noArmor);
        Monster skinned4 = new Monster("L'écorché", 10, 50, dagger, noArmor);
        Monster livingArmor = new Monster("L'armure vivante", 100, 2, broadsword, steelArmor);
        Monster prisonner = new Monster("Le prisonnier", 100, 10, dagger, noArmor);

        if(Objects.equals(player.getSavePoint(), "cour")) {
            Utils.textLine("Vous vous dirigez vers les couloirs sombres de l'aile Ouest de la prison.");
            Utils.textLine("Sur le chemin, vous croisez d'autres écorchés armés de dagues!");
            Program.fight(player, skinned1);
            Utils.textLine("Un autre écorché vous attaque!");
            Program.fight(player, skinned2);
            Utils.textLine("Encore un écorché!");
            Program.fight(player, skinned3);
            Utils.textLine("Encore un autre écorché!");
            Program.fight(player, skinned4);
            Utils.textLine("Vous en avez fini avec tous ces écorchés qui vous barraient la route.");
            Utils.textLine("Vous continuez dans les couloirs, et tombez sur un prisonnier comme vous.");
            String choice = "0";
            while (Objects.equals(choice, "0")) {
                System.out.println("Que faites vous?\n1. Vous le libérez\n2. Vous passez votre chemin.");
                choice = in.nextLine();
                switch (choice) {
                    case "1":
                        Utils.textLine("Vous libérez le prisonnier d'un coup dans le cadenas.");
                        Utils.textLine("Le prisonnier vous remercie avec un sourire inquiétant.");
                        Utils.textLine("Une fois le prisonnier salué, vous vous retournez pour continuer votre chemin.");
                        Utils.textLine("C'est alors que le prisonnier vous saute à la gorge en vous infligeant 40 points de dégâts d'un coup de dague!");
                        Utils.textLine("Vous le repoussez en arrière, et vous retournez mal en point.");
                        player.looseHealth(40);
                        Program.fight(player, prisonner);
                        Utils.textLine("Vous continuez votre chemin et trouvez un feu de camp dans une cellule dont la porte a été détruite.");
                        break;
                    case "2":
                        Utils.textLine("Vous passez votre chemin et entendez le prisonnier vociférer des insultes après vous.");
                        Utils.textLine("Vous arrivez à un feu de camp dans une cellule dont la porte a été détruite.");
                        break;
                    default:
                        System.out.println("Veuillez choisir un chiffre de la liste.");
                        choice = "0";
                        break;
                }
            }
            player.setSavePoint("hall");
        }
        if(Objects.equals(player.getSavePoint(), "hall")) {
            Program.bonfire(player, "hall");
            Utils.textLine("Le jeu s'arrête ici pour l'instant! Merci d'avoir joué!");
            Menu.run();
        }
    }
}

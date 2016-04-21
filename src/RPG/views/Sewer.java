package RPG.views;

import RPG.controllers.Program;
import RPG.models.*;

import java.util.Objects;
import java.util.Scanner;

public class Sewer {
    public static void sewer(Player player ) {
        if (Objects.equals(player.getSavePoint(), "cour")) {

            Scanner in = new Scanner(System.in);

            //declarations of potions(type, ammount)
            Potion tinyHealthPotion = new Potion("Petite potion de soin", "health", 30);

            //Declarations of armors(name, defense)
            Armor noArmor = new Armor("", 0);
            Armor ironArmor = new Armor("Armure en fer", 7);
            Armor lightArmor = new Armor("Armure légère", 4);

            //Declarations of weapons(name, damagesMax, damagesMin)
            Weapon noWeapon = new Weapon("", 0, 0);
            Weapon dagger = new Weapon("Dague", 2, 5);
            Weapon claw = new Weapon("Griffes", 4, 9);
            Weapon Sword = new Weapon("Epée rouillée", 4, 6);

            //Declarations of monsters(name, healthPoints, speed, weapon, armor)
            Monster drunkard = new Monster("L'ivrogne", 60, 50, dagger, noArmor);
            Monster panther = new Monster("La panthère", 90, 200, claw, noArmor);
            Monster giantRat = new Monster("Le rat géant", 50, 100, claw, noArmor);
            Monster knight = new Monster("Le chevalier", 100, 10, Sword, lightArmor);
            Monster knight2 = new Monster("Le chevalier", 100, 50, Sword, lightArmor);

            Utils.textLine("Vous entrez dans les égouts.");
            Utils.textLine("L'odeur nauséabonde vous prends au nez, et vous vous retrouvez dans l'obscurité.");
            Utils.textLine("Alors que vous tentez d'appercevoir quelque chose, un bruit attire votre attention.");
            Utils.textLine("Dans l'obscurité, vous parvenez à entrevoir un rat d'une taille impressionante.");
            Program.fight(player, giantRat);

            Utils.textLine("Après avoir tué le rat, vous continuez à avancer dans le noir, jusqu'à voir une lueur dans les tunnels.");
            String choice = "0";
            while (Objects.equals(choice, "0")) {
                System.out.println("Que faites vous?\n1. Vous vous approchez\n2. Vous faites le tour");
                choice = in.nextLine();
                switch (choice) {
                    case "1":
                        Utils.textLine("Vous vous approchez sans faire attention au piège se trouvant par terre.");
                        Utils.textLine("Le piège se referme sur vous, vous faisant perdre 20 PV, et vous empêchant de fuir.");
                        player.looseHealth(20);
                        Utils.textLine("Un homme qui était assis près du feu de camp non-loin, se lève et dégaine son épée.");
                        Program.fight(player, knight2);
                        Utils.textLine("Vos avez vaincu le chevalier, et vous vous approchez de son feu de camp.Vous ramassez au passage son armure.");
                        player.addItem(lightArmor);
                        break;
                    case "2":
                        Utils.textLine("Vous faites le tour et voyez un homme assis à un feu de camp.");
                        Utils.textLine("En vous approchant, il vous remarque et tire son épée.");
                        Program.fight(player, knight);
                        Utils.textLine("Vos avez vaincu le chevalier, et vous vous approchez de son feu de camp.Vous ramassez au passage son armure.");
                        player.addItem(lightArmor);
                        break;
                    default:
                        System.out.println("Veuillez choisir un chiffre de la liste.");
                        choice = "0";
                        break;
                }
            }
        }
        if (Objects.equals(player.getSavePoint(), "sewer")) {
            Program.bonfire(player, "sewer");
            Utils.textLine("Le jeu touche à sa fin pour l'instant! MErci d'avoir joué!");
            Menu.run();
        }
    }
}

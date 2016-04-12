package RPG.views;

import RPG.controllers.Program;
import RPG.models.Armor;
import RPG.models.Monster;
import RPG.models.Player;
import RPG.models.Weapon;

import java.util.Scanner;

public class Game {

    public static void newGame(Player player) {
        //Declarations of armors
        Armor noArmor = new Armor(0);
        Armor lightArmor = new Armor(5);
        Armor steelArmor = new Armor(30);

        //Declarations of weapons
        Weapon noWeapon = new Weapon(0, 0);
        Weapon fists = new Weapon(1, 3);
        Weapon dagger = new Weapon(2, 5);
        Weapon broadsword = new Weapon(20, 30);

        //Declarations of monsters(name, healthPoints, weapon, armor)
        Monster skinned = new Monster("L'écorché", 10, noWeapon, noArmor);
        Monster livingArmor = new Monster("L'armure vivante", 100, broadsword, steelArmor);

        int choice = 0;
        player.setWeapon(fists);
        player.setArmor(noArmor);
        Scanner in = new Scanner(System.in);

        Utils.textLine("Vous vous réveillez dans une cellule dégoûtante...");
        Utils.textLine("Vous vous baissez, et appercevez un objet brillant par terre : La clé!");
        Utils.textLine("Vous ouvrez la porte, et avancez dans un couloir sombre. Un bruit de pas lourd au loin vous fait frissonner.");
        Utils.textLine("Vous rencontrez un homme vêtu d'un pagne il est de dos. Que faites vous?");
        while (choice == 0) {
            System.out.println("1. Vous vous approchez pour lui parler\n2. Vous le frappez dans le dos\n3. Vous passez votre chemin");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    Utils.textLine("Il se retourne et vous voyez son visage décomposé. Cet homme est visiblement déjà mort.");
                    Utils.textLine("Il semble avoir perdu la raison et commence à agiter ses bras dans votre direction.");
                    Utils.textLine("Vous levez les poings, prêt à vous battre.");
                    break;
                case 2:
                    Utils.textLine("Vous levez les poings et le frappez violement dans le dos.");
                    Utils.textLine("Il se retourne et vous voyez son visage en putréfaction.");
                    Utils.textLine("L'homme déjà mal en point se relève et vous attaque.");
                    break;
                case 3:
                    Utils.textLine("Vous passez à côté de l'homme sans rien dire.");
                    Utils.textLine("L'homme vous remarque et se retourne, son visage écorché vous apparaît.");
                    Utils.textLine("Il crie quelque chose d'incompréhensible et se rue vers vous.");
                    break;
                default:
                    Utils.textLine("Veuillez choisir un chiffre de la liste.");
                    choice = 0;
            }
        }
        Program.fight(player, skinned);

        Utils.textLine("Après avoir tué l'écorché, vous continuez votre chemin.");
        Utils.textLine("Trois chemins s'offrent à vous :");
        choice = 0;
        boolean firstPast = true;
        while(choice == 0){
            if(firstPast) {
                System.out.println("1. Une cellule à gauche\n2. Tout droit dans le couloir\n3. Une porte à droite");
            }else{
                System.out.println("1. La cellule à gauche\n2. Tout droit dans le couloir\n3. La porte à droite");
            }
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    if(firstPast) {
                        Utils.textLine("Dans la cellule, vous trouvez une dague "+dagger.getDamagesAsString()+". Vous retournez ensuite vers le couloir.");
                        player.setWeapon(dagger);
                        firstPast = false;
                        choice = 0;
                        break;
                    }else{
                        Utils.textLine("Vous êtes déjà passé par ici...");
                        choice = 0;
                        break;
                    }
                case 2:
                    Utils.textLine("Vous tombez face à une armure vivante de deux mètres de haut.");
                    Utils.textLine("L'armure lève son espadon et l'abat sur vous.");
                    Program.fight(player, livingArmor);
                    Utils.textLine("Vous avez vaincu l'armure vivante et avez récupéré son espadon "+broadsword.getDamagesAsString()+" !");
                    player.setWeapon(broadsword);
                    break;
                case 3:
                    Utils.textLine("La porte à droite vous mène à une cour avec un feu de camp au milieu.");
                    break;
                default:
                    Utils.textLine("Veuillez choisir un chiffre de la liste");
                    choice = 0;
            }
        }
    }
}

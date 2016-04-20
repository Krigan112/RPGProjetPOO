package RPG.views;

import RPG.controllers.Program;
import RPG.models.*;

import java.util.Objects;
import java.util.Scanner;

public class WasteLands {
    public static void wasteLands(Player player) {
        Scanner in = new Scanner(System.in);

        //declarations of potions(type, ammount)
        Potion tinyHealthPotion = new Potion("Petite potion de soin", "health", 30);

        //Declarations of armors(name, defense)
        Armor noArmor = new Armor("", 0);

        //Declarations of weapons(name, damagesMax, damagesMin)
        Weapon noWeapon = new Weapon("", 0, 0);
        Weapon dagger = new Weapon("Dague", 2, 5);
        Weapon claw = new Weapon("Griffes", 4, 9);

        //Declarations of monsters(name, healthPoints, speed, weapon, armor)
        Monster drunkard1 = new Monster("L'ivrogne", 60, 50, dagger, noArmor);
        Monster drunkard2 = new Monster("L'ivrogne", 60, 50, dagger, noArmor);
        Monster drunkard3 = new Monster("L'ivrogne", 60, 50, dagger, noArmor);
        Monster panther = new Monster("La panthère", 90, 200, claw, noArmor);

        boolean wasteLandsHelp = false;

        if (Objects.equals(player.getSavePoint(), "cour")) {


            Utils.textLine("Vous passez l'immense porte, qui vous mène à des terres dévstées.");
            Utils.textLine("Un vieil homme vous regarde d'un air méfiant.");
            Utils.textLine("Pointant sa canne vers vous, il vous dit: ");
            Utils.textLine("\"Que fais tu là toi? Tu es sorti de la prison? Ou en est-tu un gardien?\"");
            String choice = "0";
            while (Objects.equals(choice, "0")) {
                System.out.println("Que lui répondez-vous?\n1. Fugitif\n2. Gardien");
                choice = in.nextLine();
                switch (choice) {
                    case "1":
                        Utils.textLine("Ah! Vous vous êtes donc évadés de cette maudite prison vous aussi?");
                        Utils.textLine("D'autres aussi sont sortis d'ici. Ils sont partis vers le Nord.");
                        wasteLandsHelp = true;
                        Utils.textLine("Tenez, prenez ça, ça vous sera utile.");
                        Utils.textLine("Le vieil homme vous tends deux petites fioles remplies d'un liquide rouge vif.");
                        player.addItem(tinyHealthPotion);
                        player.addItem(tinyHealthPotion);
                        Utils.textLine("Ce sont des potions de soins. Elles vous rendront quelques PV si vous les buvez.");
                        break;
                    case "2":
                        wasteLandsHelp = false;
                        Utils.textLine("Vous êtes donc un des gardiens de cette prison?.. Et bien hors de ma vue! Je n'aprécie guère les gens comme vous...");
                        break;
                    default:
                        System.out.println("Veuillez choisir un chiffre de la liste");
                        choice = "0";
                        break;
                }
            }
            if (wasteLandsHelp) {
                Utils.textLine("Vous continuez vers le Nord, comme indiqué par le vieillard.");
                Utils.textLine("Vous arrivez près d'une oasis.");
                Utils.textLine("Vous vous approchez pour boire, mais une créature vous saute dessus!");
                Program.fight(player, panther);
                Utils.textLine("Après avoir vaincu la panthère, vous buvez à l'oasis, et entendez des voix.");
                Utils.textLine("Vous repérez un groupe de trois personnes qui discutent autour d'un feu de camp.");
                Utils.textLine("Vous vous approchez, et êtes acceuillis chaleureusement par les trois hommes.");
                Utils.textLine("Ils vous invitent à vous joindre à eux!");
                Program.bonfire(player, "oasis");
            }
            if (!wasteLandsHelp) {
                Utils.textLine("Vous continuez votre route vers l'Est.");
                Utils.textLine("Après de longues heures de marche, vous vous retournez, et vous vous appercevez que la prison est bien loin.");
                Utils.textLine("Vous commencez à avoir soif.");
                Utils.textLine("Vous voyez au loin une forme rappellant un bâtiment, et vous dirigez donc vers celle-ci.");
                Utils.textLine("Arrivé là bas, un grand homme vous barre la route:");
                Utils.textLine("Hé! Où compte-tu aller comme ça? Cette maison ne t'appartient pas!");
                Utils.textLine("Hmm... Tu m'a l'air bien mal en point.");
                Utils.textLine("Bon. Ça va pour cette fois. Entre!");
                Utils.textLine("Vous entrez et voyez des gens festoyer au centre de la pièce.");
                Utils.textLine("Une grosse dame vous propose une bière, et vous acceptez.");
                Utils.textLine("Tout à coup, vous entendez le ton monter vers la table au milieu de la pièce.");
                Utils.textLine("Un des hommes se lève, dégaine son épée, et tranche la gorge de son voisin d'en face!");
                Utils.textLine("Les deux homme restants se lèvent à leur tour, et dégainent eux aussi leur armes.");
                Utils.textLine("Vous vous retrouvez pris dans une bagarre d'ivrognes malgré vous.");
                Program.fight(player, drunkard1);
                Utils.textLine("Un deuxième ivrogne se dirige vers vous!");
                Program.fight(player, drunkard2);
                Utils.textLine("Jamais deux sans trois...");
                Program.fight(player, drunkard3);
                Utils.textLine("Après avoir vaicu les ivrognes, vous vous laissez tomber dans un fauteuil près de la cheminée.");
                Program.bonfire(player, "youth");
            }
        }
        if (Objects.equals(player.getSavePoint(), "oasis")) {
            Program.bonfire(player, "oasis");
            Utils.textLine("Ceci est la fin du jeu pour l'instant! Merci d'avoir joué!");
            Menu.run();
        }
        if(Objects.equals(player.getSavePoint(), "youth")){
            Program.bonfire(player, "youth");
            Utils.textLine("Ceci est la fin du jeu pour l'instant! Merci d'avoir joué!");
            Menu.run();
        }
    }
}

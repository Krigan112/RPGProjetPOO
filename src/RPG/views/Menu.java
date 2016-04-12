package RPG.views;

import java.util.Scanner;

public class Menu
{
    public static void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("               RPG                ");
        System.out.println("");
        System.out.println("---------------Menu---------------");
        System.out.println("1        Nouvelle partie");
        //System.out.println("2          Sauvegarder");
        System.out.println("2            Charger");
        //System.out.println("4            Options");
        System.out.println("3            Quitter");

        switch (in.nextInt()){
            case 1:
                RPG.controllers.Options.newGame();
                break;
            /*
            case 2:
                RPG.controllers.Options.save(player);
                break;
                */
            case 2:
                RPG.views.GameOptions.loadPannel(in);
                break;
            /*
            case 4:
                RPG.views.GameOptions.optionsPannel();
                break;
            */
            case 3:
                RPG.controllers.Options.exit();
                break;
            default:
                System.out.println("Ce choix n'est pas dans la liste...");
                run();
        }
    }
}

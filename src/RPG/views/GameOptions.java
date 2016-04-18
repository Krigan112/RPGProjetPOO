package RPG.views;

import RPG.models.Player;

import java.util.Scanner;

public class GameOptions
{
    /*
    public static void optionsPannel(){
        System.out.println("---------------Options---------------");
        System.out.println("1            Difficulté");
    }
    */

    public static void loadPannel() {
        Scanner i = new Scanner(System.in);
        System.out.println("Veuillez entrer le nom du personnage que vous voulez charger : ");
        Player loadRequest = new Player();
        String name = i.nextLine();
        loadRequest.setName(name);
        RPG.controllers.Options.load(loadRequest);
    }
}

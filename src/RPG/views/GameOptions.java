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

    public static void loadPannel(Scanner in) {
        System.out.println("Veuillez entrer le nom du personnage que vous voulez charger : ");
        Player loadRequest = new Player();
        loadRequest.setName(in.nextLine());
        RPG.controllers.Options.load(loadRequest);
    }
}

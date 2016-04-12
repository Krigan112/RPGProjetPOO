package RPG.views;

import RPG.models.Player;
import RPG.models.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class Utils
{
    public static void chooseYourName(Player player, Scanner in) {
        System.out.println("Entrez le nom de votre personnage : ");
        player.setName(in.nextLine());
        System.out.println("Vous vous appelez donc \""+player.getName()+"\" ? (o/n)");
        if(in.nextLine().equals("o")){
            System.out.println("D'accord! "+player.getName()+" préparez vous...");
        }else{
            chooseYourName(player, in);
        }
    }

    public static void textLine(String output){
        Scanner text = new Scanner(System.in);
        System.out.println(output);
        text.nextLine();
    }

    public static String healthGauge(Character character){
//        ArrayList <String> gaugeAsList = new ArrayList<>();
        String gauge = "";
        for(int i=1; i<=character.getHealthPoints(); i++){
            gauge = gauge+"=";
        }
        return ("["+gauge+"]");
    }
}

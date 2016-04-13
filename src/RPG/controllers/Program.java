package RPG.controllers;

import RPG.models.Monster;
import RPG.models.Player;
import RPG.views.Utils;

public class Program
{
    public static void main(String[] args){
        RPG.views.Menu.run();
    }

    public static boolean fight(Player player, Monster monster){
        while(player.getHealthPoints()!=0 && monster.getHealthPoints()!=0){

            if(!player.action(player, monster)){
                return false;
            }

            if(monster.getHealthPoints()<=0){
                Utils.textLine("Vous avez tué "+monster.getName()+".");
                return true;
            }

            monster.attack(player, monster);

            if(player.getHealthPoints()<=0){
                Utils.textLine("Vous êtes mort.");
                RPG.views.Menu.run();
            }
        }
        return false;
    }
}

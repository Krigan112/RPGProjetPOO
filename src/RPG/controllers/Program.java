package RPG.controllers;

import RPG.models.Monster;
import RPG.models.Player;
import RPG.views.Utils;

public class Program
{
    public static void main(String[] args){
        RPG.views.Menu.run();
    }

    public static void fight(Player player, Monster monster){
        while(player.getHealthPoints()!=0 && monster.getHealthPoints()!=0){

            player.action(player, monster);

            if(monster.getHealthPoints()<=0){
                Utils.textLine("Vous avez tué "+monster.getName()+".");
                break;
            }

            monster.attack(player, monster);

            if(player.getHealthPoints()<=0){
                Utils.textLine("Vous êtes mort.");
                RPG.views.Menu.run();
                break;
            }
        }
    }
}

package RPG.models;

import RPG.views.Utils;

public class Monster extends Character
{
    public Monster(String name, int healthPoints, Weapon weapon, Armor armor){
        this.name = name;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
        this.armor = armor;
    }

    public Monster(){

    }

    public void attack(Player player, Monster monster) {
        System.out.println(monster.getName()+" vous attaque!");
        player.looseHealth(monster.getDamages()-player.getDefense());
        System.out.println("Vous avez perdu "+(monster.getDamages()-player.getDefense())+" points de vie. Il vous reste "+player.getHealthPoints()+"PV");
    }
}

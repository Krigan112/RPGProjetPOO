package RPG.models;

public class Monster extends Character
{
    public Monster(String name, int healthPoints, int speed, Weapon weapon, Armor armor){
        this.name = name;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
        this.armor = armor;
        this.speed = speed;
    }

    public Monster(){

    }

    public void attack(Player player, Monster monster) {
        System.out.println(monster.getName()+" vous attaque!");
        player.looseHealth(monster.getDamages()-player.getDefense());
        System.out.println("Vous avez perdu "+(monster.getDamages()-player.getDefense())+" points de vie. Il vous reste "+player.getHealthPoints()+"PV");
    }
}

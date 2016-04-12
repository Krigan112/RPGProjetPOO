package RPG.models;

import java.lang.*;
import java.io.Serializable;

public class Character implements Serializable
{
    protected String name;
    protected int healthPoints;
    protected Weapon weapon;
    protected Armor armor;

    //setters
    public void setName(String name){this.name = name;}
    public void setWeapon(Weapon weapon){this.weapon = weapon;}
    public void setArmor(Armor armor){this.armor = armor;}

    //getters
    public String getName(){return this.name;}
    public int getHealthPoints(){return this.healthPoints;}
    public int getDamages(){return this.weapon.getDamages();}
    public int getDefense(){return this.armor.getDefense();}

    public void looseHealth(int amount) {
        this.healthPoints = this.healthPoints-amount;
    }
}

package RPG.models;

import java.util.Random;

public class Weapon extends Item{

    private int damagesMin;
    private int damagesMax;

    public Weapon(String name, int damagesMin, int damagesMax) {
        this.damagesMin = damagesMin;
        this.damagesMax = damagesMax;
        this.name = name;
    }

    //getters
    public int getDamages(){
        Random rand = new Random();
        return rand.nextInt((this.damagesMax-this.damagesMin)+1)+this.damagesMin;
    }
    public String getDamagesAsString(){
        return "("+this.damagesMin+", "+this.damagesMax+")";
    }
}

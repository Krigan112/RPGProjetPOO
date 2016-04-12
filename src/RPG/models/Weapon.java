package RPG.models;

import java.util.Random;

public class Weapon {

    private int damagesMin;
    private int damagesMax;

    public Weapon(int damagesMin, int damagesMax) {
        this.damagesMin = damagesMin;
        this.damagesMax = damagesMax;
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

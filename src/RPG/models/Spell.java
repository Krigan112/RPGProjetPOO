package RPG.models;

import java.io.Serializable;

public class Spell implements Serializable {
    private String name;
    private int damages;
    private int ammo;
    private int ammoMax;

    public Spell(String name, int damages, int ammoMax) {
        this.name = name;
        this.damages = damages;
        this.ammoMax = ammoMax;
        this.ammo = ammoMax;
    }

    //Getters
    public String getName() {return name;}
    public int getAmmo() {return ammo;}
    public int getDamages() {return damages;}
    public int getAmmoMax() {return ammoMax;}

    //Setters
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}

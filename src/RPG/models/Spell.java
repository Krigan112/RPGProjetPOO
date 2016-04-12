package RPG.models;

public class Spell {
    private String name;
    private int damages;
    private int ammo;

    public Spell(String name, int damages, int ammo) {
        this.name = name;
        this.damages = damages;
        this.ammo = ammo;
    }

    //Getters
    public String getName() {return name;}
    public int getAmmo() {return ammo;}
    public int getDamages() {return damages;}

    //Setters
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}

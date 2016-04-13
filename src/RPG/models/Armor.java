package RPG.models;

public class Armor extends Item{

    private int defense = 0;

    public Armor(String name, int defense) {
        this.defense = defense;
        this.name = name;
    }

    //getters
    public int getDefense(){return this.defense;}

    public String getDefenseAsString() {
        return "(" + this.defense + ")";
    }
}

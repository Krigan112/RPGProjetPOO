package RPG.models;

public class Potion extends Item{
    private String type;
    private int ammount;

    public Potion(String name, String type, int ammount){
        this.name = name;
        this.type = type;
        this.ammount = ammount;
    }

    //getters
    public String getType(){return this.type;}
    public int getAmmount(){return this.ammount;}

}

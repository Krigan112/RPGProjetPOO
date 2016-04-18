package RPG.models;

import RPG.views.Utils;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Player extends Character
{

    private ArrayList<Spell> spellList = new ArrayList<>();
    private ArrayList<Item> inventory = new ArrayList<>();
    private static final long serialVersionUID = 1L;
    private String savePoint;

    public Player(){
        this.speed = 30;
        this.healthPoints = 100;
    }

    //getters
    public String getSavePoint(){return savePoint;}
    public ArrayList<Spell> getSpells(){return spellList;}
    public ArrayList<Item> getInventory(){return inventory;}

    //setters
    public void setSavePoint(String savePoint) {this.savePoint = savePoint;}
    public void setHealthPoints(int healthPoints) {this.healthPoints = healthPoints;}

    // if action() returns true, the player just do something (like attack or cast a spell)
    // but if action() returns false, it means that he didn't do anything. so he flyed;
    public boolean action(Player player, Monster monster) {
        Scanner in = new Scanner(System.in);
        System.out.println("Vous: "+Utils.healthGauge(player));
        System.out.println("Adversaire: "+Utils.healthGauge(monster));
        Utils.textLine("Que faites vous?");
        String choice = "0";
        while(Objects.equals(choice, "0")) {
            System.out.println("1. Attaque\n2. Magie\n3. Fuir\n4. Inventaire");
            choice = in.next();
            switch (choice) {
                case "1":
                    System.out.println("Vous attaquez.");
                    player.attack(monster);
                    break;
                case "2":
                    choice = Utils.spells(player, monster);
                    break;
                case "3":
                    if(player.speed>monster.speed){
                        System.out.println("Vous prenez la fuite.");
                        return false;
                    }else{
                        System.out.println(monster.getName()+" vous ratrappe.");
                        break;
                    }
                case "4":
                    Utils.inventory(player);
                    choice = "0";
                    break;
                default:
                    System.out.println("Veuillez choisir un chiffre de la liste.");
                    choice = "0";
            }
        }
        return true;
    }

    public void cast(Monster monster, int spell) {
        if (spellList.get(spell).getAmmo() > 0) {
            monster.looseHealth(spellList.get(spell).getDamages());
            spellList.get(spell).setAmmo(spellList.get(spell).getAmmo() - 1);
            System.out.println("Vous avez infligé "+spellList.get(spell).getDamages()+" points de dégâts à "+monster.getName()+".");
        }else{
            System.out.println("Vous n'avez plus de munitions pour ce sort.");
            Utils.spells(this, monster);
        }
    }

    public void equip(int item){
        if((this.getInventory().get(item))instanceof Potion){
            System.out.println("Vous avez bu: "+this.getInventory().get(item).getName());
            this.drinkPotion((Potion)this.getInventory().get(item), item);
        }else if((this.getInventory().get(item))instanceof Weapon){
            this.setWeapon((Weapon) this.getInventory().get(item));
            System.out.println("Vous avez équipé: "+weapon.getName()+weapon.getDamagesAsString());
        }else if((this.getInventory().get(item))instanceof Armor){
            this.setArmor((Armor) this.getInventory().get(item));
            System.out.println("Vous avez équipé: "+armor.getName()+armor.getDefenseAsString());
        }else{
            System.out.println("Vous ne pouvez pas vous équiper de cet objet.");
        }
    }

    private void drinkPotion(Potion potion, int index) {
        this.setHealthPoints(this.getHealthPoints()+potion.getAmmount());
        this.deleteItem(index);
    }

    private void deleteItem(int index) {
        this.getInventory().remove(index);
    }

    private void attack(Monster monster) {
        int damages = monster.looseHealth(this.getDamages()-monster.getDefense());
        System.out.println(monster.getName()+" a perdu "+(damages-monster.getDefense())+" points de vie. Il lui reste "+monster.getHealthPoints()+"PV");
    }

    public void addSpell(String name, int damages, int ammo){
        Spell newSpell = new Spell(name, damages, ammo);
        this.spellList.add(newSpell);
    }

    public void addItem(Item item){
        this.inventory.add(item);
    }
}

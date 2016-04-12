package RPG.controllers;
import RPG.models.Player;
import RPG.views.Game;

import java.io.*;
import java.util.Scanner;


public class Options
{
    public static void newGame(){
        Player player = new Player();
        Scanner in = new Scanner(System.in);
        RPG.views.Utils.chooseYourName(player, in);
        Game.newGame(player);
    }

    public static void save(Player player) {
        FileOutputStream fileOutStr = null;
        if (player.getName() == null) {
            try {
                fileOutStr = new FileOutputStream(new File("src/RPG/saves/saveOf" + player.getName() + ".txt"));
                ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);

                objOutStr.writeObject(player);

            } catch (FileNotFoundException err) {
                err.printStackTrace();
            } catch (IOException err) {
                err.printStackTrace();
            } finally {
                try {
                    if (fileOutStr != null) fileOutStr.close();
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
            System.out.println("Sauvegarde réussie!");
            RPG.views.Menu.run();
        }else{
            System.out.println("Erreur! Vous n'avez pas créé de personnage!");
            RPG.views.Menu.run();
        }
    }

    public static void load(Player player){
        FileInputStream fileInStr = null;
        try{
           fileInStr = new FileInputStream(new File("src/RPG/saves/saveOfBob.txt"));
           ObjectInputStream objInStr = new ObjectInputStream(fileInStr);
            player = (Player) objInStr.readObject();

        }catch(FileNotFoundException err){
            err.printStackTrace();
        }catch(IOException err){
            err.printStackTrace();
        }catch(ClassNotFoundException err){
            err.printStackTrace();
        }finally {
            try{
                if(fileInStr != null) fileInStr.close();
            }catch(IOException err){
                err.printStackTrace();
            }
        }
        System.out.println("Chargement réussi! Bonjour, "+player.getName());
    }

    public static void exit(){
        System.exit(1);
    }
}
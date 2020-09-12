import attributes.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class Data {
    private static Formatter save;

    public static boolean loadData() {
        File folder = new File("data");
        if(!folder.exists()) {
            if(folder.mkdir()) {
                System.out.println("Data folder created to store saves...");
            }
        }
        try {
            File saveFile = new File("data/save.txt");
            if (!saveFile.exists()) {
                save = new Formatter("data/save.txt");
                System.out.println("Creating new save file...");
                return false;
            }
            save = new Formatter("data/save.txt");
            //Game.setPlayer(new Player(read from file));
            //Game.setRound(read from file);
            System.out.println("Loading save file...");
        } catch (FileNotFoundException e) {
            System.out.println("File error oh no!");
            return false;
        }
        return true;
    }

    public static void saveData() {
        Player player = Game.getPlayer();
        save.format("%s %d %d %d %d %d", player.getName(), player.getMaxHealth(), player.getAttack(),
                player.getDefense(), player.getSpeed(), Game.getRound());
    }

    public static void closeFile() {
        save.close();
    }
}

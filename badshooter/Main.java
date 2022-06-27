package badshooter;

import badshooter.creatures.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("Max");
        Monster monster = new Monster();
        while (!player.isDead() && !monster.isDead()) {
            player.useItem(monster, player);
            Thread.sleep(2000);
            monster.bite(player);
        }
    }
}
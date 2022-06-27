package badshooter.items;

import badshooter.creatures.Player;

public abstract class Aid extends Item {

    protected int healValue;

    @Override
    public void heal(Player player) {
        player.increaseHealth(healValue);
        System.out.println("Player is healed for " + healValue);
        player.maxHealthLimit();
        qty--;
    }

    @Override
    public String toString() {
        return name + " - " + qty + " charge(s) [heal = " + healValue + "]";
    }
}

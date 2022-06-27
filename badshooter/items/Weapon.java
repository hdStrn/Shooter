package badshooter.items;

import badshooter.Chance;
import badshooter.creatures.Monster;

import java.util.List;

public abstract class Weapon extends Item {

    protected int accuracy;
    protected int damage;

    @Override
    public void shot(Monster monster) throws InterruptedException {
        if (Chance.isSuccessful(accuracy)) {
            monster.decreaseHealth(damage);
            if (monster.getHealth() > 0) {
                System.out.println("Nice shot! Monster health is " + monster.getHealth() + "\n");
            } else {
                System.out.println("Nice shot! Monster is dead (?)\n");
                Thread.sleep(2000);
            }
        } else {
            System.out.println("You missed :(\n");
        }
        qty--;
    }

    @Override
    public String toString() {
        return name + " - " + qty + " bullet(s) [damage = " + damage + ", accuracy = " + accuracy + "]";
    }
}

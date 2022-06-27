package badshooter.creatures;

import badshooter.Chance;
import badshooter.items.Item;
import badshooter.items.Weapon;

import java.util.List;

import static badshooter.items.Item.items;

public class Monster extends Creature {

    private int damage = 10;
    private int maxHealth = 100;
    private final List<String> NAMES = List.of("Imp", "Skeleton", "Zombie", "Vampire", "Demon");
    private int count;

    public Monster() {
        this.name = NAMES.get(count);
        this.health = maxHealth;
    }

    //метод кусания игрока монстром
    public void bite(Player player) {
        player.decreaseHealth(damage); //снижение хп игрока на величину урона монстра
        System.out.println("Arrrrggghhh! Got it, human!\n* " + name + " bites you *");
        if (player.getHealth() > 0) {
            System.out.println("Player's health is " + player.getHealth() + "\n");
        } else {
            System.out.println("Player's is dead :(\n");
        }
        player.isGameOver(); //проверка убийства игрока
    }

    //метод, вызывающий другого монстра с увеличенными параметрами, если предыдущий убит
    public void resurrect() throws InterruptedException {
        if (isDead()) { //проверка убит ли монстр
            if ("Demon".equals(name)) {
                System.out.println("Congratulations! You see the light in the end of tunnel..");
                System.exit(0);
            }
            itemsDrop(items);
            maxHealth = maxHealth + maxHealth * 10 / 100; //увеличение хп на 10%
            health = maxHealth;
            damage = damage + damage * 10 / 100; //увеличение урона на 10%
            name = NAMES.get(++count); //смена имени монстра
            isDead = false;
            System.out.println("Look! Another monster!\n");
        }
    }

    public void itemsDrop(List<Item> items) throws InterruptedException {
        System.out.println("At " + name + "'s corpse you found..");
        boolean isNothing = true;
        Thread.sleep(2000);
        for (Item item : items) {
            if (Chance.isSuccessful(item.getDropChance())) {
                item.setQty(item.getQty() + 1);
                if (item instanceof Weapon) {
                    System.out.println("1 bullet of " + item.getName());
                } else {
                    System.out.println("1 charge of " + item.getName());
                }
                isNothing = false;
            }
        }
        if (isNothing) System.out.println("Nothing :(");
    }
}

package badshooter.items;

import badshooter.creatures.Monster;
import badshooter.creatures.Player;

import java.util.List;

public abstract class Item {

    public static final List<Item> items = List.of(
            new Pistol(),
            new MachineGun(),
            new RocketLauncher(),
            new SmallAidKit(),
            new MediumAidKit(),
            new BigAidKit()
    );

    protected String name;
    protected int qty;
    protected int dropChance;

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getDropChance() {
        return dropChance;
    }

    public boolean isQtyEnough() {
        return qty > 0;
    }

    public void shot(Monster monster) throws InterruptedException {

    }

    public void heal(Player player) {

    }
}

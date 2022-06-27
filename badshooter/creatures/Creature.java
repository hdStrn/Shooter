package badshooter.creatures;

public abstract class Creature {

    protected String name;
    protected int health;
    protected boolean isDead = false;

    public int getHealth() {
        return health;
    }

    //метод снижения здоровья на величину урона
    public void decreaseHealth(int damage) {
        health -= damage;
    }

    public void increaseHealth(int heal) {
        health += heal;
    }

    //метод проверки убито ли существо
    public boolean isDead() {
        return health <= 0;
    }
}

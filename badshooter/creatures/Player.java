package badshooter.creatures;

import badshooter.items.Item;
import badshooter.items.Weapon;

import java.util.List;
import java.util.Scanner;

public class Player extends Creature {

    //список предметов и их количества у игрока
    List<Item> items = Item.items;

    //конструктор создания игрока, по умолчанию всегда 100 хп, имя задается в параметре
    public Player(String name) {
        this.name = name;
        this.health = 100;
    }

    //использование оружия/предмета
    public void useItem(Monster monster, Player player) throws InterruptedException {
        System.out.println("Choose your weapon or item:");

        //вывод списка доступных предметов с их количеством
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + ". " + items.get(i));
        }
        Scanner sc = new Scanner(System.in);
        int slot; //переменная для выбора слота с предметом - вводится пользователем

        //цикл проверки правильности ввода слота
        while (true) {
            try {
                slot = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please, enter number:");
                continue;
            }
            if (slot > 0 && slot <= items.size()) { //проверка, что такой слот существует
                if (items.get(slot - 1).isQtyEnough()) { //вызов метода проверки наличия количества предмета
                    break;
                } else {
                    System.out.println("There is no ammo, choose another one!");
                }
            } else {
                System.out.println("Choose the correct one!");
            }
        }
        Item item = items.get(slot - 1); //выбор предмета из коллекции
        if (item instanceof Weapon) { //проверка, если выбранный предмет относится к классу Оружие
            item.shot(monster); //выстрел из оружия по монстру
        } else {
            item.heal(player); //использование предмета (хилка)
        }
        monster.resurrect(); //вызов метода проверки убийства монстра и его воскрешения
    }

    public void isGameOver() {
        if (isDead()) System.out.println("Game over :(");
    }

    public void maxHealthLimit() {
        if (health > 100) health = 100;
    }
}

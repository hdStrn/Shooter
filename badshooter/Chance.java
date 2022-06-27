package badshooter;

import java.util.Random;

public class Chance {

    //метод проверки шанса
    public static boolean isSuccessful(int chance) {
        return chance >= new Random().nextInt(101);
    }
}

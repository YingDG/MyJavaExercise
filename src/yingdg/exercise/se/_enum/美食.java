package yingdg.exercise.se._enum;

import java.util.Arrays;

/**
 * Created by yingdg on 2017/8/9.
 */
public interface 美食 {

    enum Coffee implements 美食 {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum Dessert implements 美食 {
        FRUIT, CAKE, GELATO
    }

    static void main(String[] args) {
        Dessert[] values = 美食.Dessert.values();
        System.out.println(Arrays.toString(values));
    }
}

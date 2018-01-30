package yingdg.exercise.se.stringtool;

/**
 * Created by yingdg on 2017/8/14.
 */
public class 两整型数交换 {
    /*
    位移运算交换
     */
    public static void exchange1(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println(x);
        System.out.println(y);
    }

    /*
   数值相加减交换
    */
    public static void exchange2(int x, int y) {
        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println(x);
        System.out.println(y);
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        exchange1(x, y);
        exchange2(x, y);
    }
}

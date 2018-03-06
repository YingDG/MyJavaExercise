package yingdg.exercise.se.stringtool;

/**
 * Created by yingdg on 2018/3/6.
 */
public class 不用函数求平方根 {
    public static float sqrtRoot(float m) {
        if (m == 0) {
            return 0;
        }

        float i = 0;
        float x1, x2 = 0;
        while ((i * i) <= m) {
            i += 0.1;
        }
        x1 = i;
        for (int j = 0; j < 10; j++) {
            x2 = m;
            x2 /= x1;
            x2 += x1;
            x2 /= 2;
            x1 = x2;
        }
        return x2;
    }

    public static void main(String[] args) {
        System.out.println(sqrtRoot(4.0F));
    }
}

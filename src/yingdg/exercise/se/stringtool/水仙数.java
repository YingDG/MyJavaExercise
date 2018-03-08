package yingdg.exercise.se.stringtool;

/**
 * Created by yingdg on 2018/3/8.
 */
public class 水仙数 {
    public static void main(String[] args) {
        System.out.println("100-1000中的水仙花数有：");
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 10 / 10 % 10;

            //水仙花数判断要求
            if (i == (ge * ge * ge + shi * shi * shi + bai * bai * bai)) {
                System.out.println(i);
            }
        }
    }
}

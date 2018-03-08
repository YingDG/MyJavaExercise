package yingdg.exercise.se.stringtool;

import java.util.Scanner;

/**
 * Created by yingdg on 2018/3/7.
 */
public class Int反转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();

        int result = 0; //存反转的数字
        while (true) {
            int n = num % 10;//取出最低位上的数字，也可以直接打印出来
            System.out.println(n);//但不好，也可以用一个数组存起来，也不好，都因为翻转后的前后的那个0的问题

            result = result * 10 + n;//依次的反转存储得到反转的数字
            num = num / 10;//原数降位
            if (num == 0) {
                break;
            }
        }

        System.out.println(result);
    }
}

package yingdg.exercise.se.stringtool;

/**
 * Created by yingdg on 2017/8/14.
 */
public class 字符串全排列 {
    /*
    方法一
     */
    public static void print1(char[] buf, int start, int end) {
        // 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
        if (start == end) {
            for (int i = 0; i <= end; i++) {
                System.out.print(buf[i]);
            }
            System.out.println();
        }

        // 多个字母全排列
        else {
            for (int i = start; i <= end; i++) {
                char temp = buf[start];// 交换数组第一个元素与后续的元素
                buf[start] = buf[i];
                buf[i] = temp;

                print1(buf, start + 1, end);// 后续元素递归全排列

                temp = buf[start];// 将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        print1("abc".toCharArray(), 0, 2);
    }
}

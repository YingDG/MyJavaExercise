package yingdg.exercise.se.stringtool;

//import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * Created by yingdg on 2017/8/14.
 */
public class 反转字符串 {

    /*
    基本方法
     */
    public static String reverseStr1(String str) {
        char[] chars = str.toCharArray();

        int l = str.length();
        char[] o = new char[l];
        for (int i = 0; i < l; i++) {
            o[i] = chars[l - i - 1];
        }

        return new String(o);
    }

    public static String reverseStr1_2(String str) {
        char[] chars = str.toCharArray();

        int l = str.length();
        for (int i = 0; i < l / 2; i++) {
            char t = chars[i];
            chars[i] = chars[l - i - 1];
            chars[l - i - 1] = t;
        }

        return new String(chars);
    }

    /*
    栈结构
     */
    public static String reverseStr2(String str) {
        char[] chars = str.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            stack.push(ch);
        }
        char[] c = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            c[i] = stack.pop();
        }

        return new String(c);
    }

    /*
    lang包
     */
//    public static String reverseStr3(String str) {
//        return StringUtils.reverse(str);
//    }

    /*
    异或运算
     */
    public static String reverseStr4(String str) {
        char[] charArray = str.toCharArray();

        int l = str.length() - 1;
        for (int i = 0; i < l; i++, l--) {
            charArray[i] ^= charArray[l];
            charArray[l] ^= charArray[i];
            charArray[i] ^= charArray[l];
        }

        return new String(charArray);
    }

    /*
    递归
     */
    public static String reverseStr5(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            return reverseStr5(str.substring(1)) + str.toCharArray()[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseStr1("abc"));
        System.out.println(reverseStr1_2("abc"));
        System.out.println(reverseStr2("abc"));
//        System.out.println(reverseStr3("abc"));
        System.out.println(reverseStr4("abc"));
        System.out.println(reverseStr5("abc"));
    }
}

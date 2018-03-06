package yingdg.exercise.se.stringtool;

/**
 * Created by yingdg on 2018/3/6.
 */
public class 整数进制转换 {
    public static void main(String[] args) {
//        十进制转成十六进制：
        String hexString = Integer.toHexString(128);
        System.out.println(hexString);
//        十进制转成八进制
        String octalString = Integer.toOctalString(128);
        System.out.println(octalString);
//        十进制转成二进制
        String binaryString = Integer.toBinaryString(128);
        System.out.println(binaryString);
        System.out.println("length:" + binaryString.length());
//        十六进制转成十进制
        String s16 = Integer.valueOf("FFFF", 16).toString();
        System.out.println(s16);
//        八进制转成十进制
        String s8 = Integer.valueOf("76", 8).toString();
        System.out.println(s8);
//        二进制转十进制
        String s2 = Integer.valueOf("0101", 2).toString();
        System.out.println(s2);
    }
}

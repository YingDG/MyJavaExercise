package yingdg.exercise.se.stringtool;

/**
 * Created by YingDG on 2017/4/6.
 */
public class 字符ASCII码 {
    public static void main(String[] args) {
        /*
        输出单字符ASCII码
         */
        int i = "a".codePointAt(0); // 97
        System.out.println(i);

        int i1 = "A".codePointAt(0); // 65
        System.out.println(i1);

        int i2 = "z".codePointAt(0); // 97+25
        System.out.println(i2);

        int i3 = "Z".codePointAt(0); // 65+25
        System.out.println(i3);

        String s1 = "a";
        String s2 = s1.concat("b").concat("C");
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals("a")); // equals方法应满足自反性、传递性、一致性

        System.out.println((char) 97); // ascii码转char

        // 字母后移
        int z = "B".codePointAt(0);
        int add = 52;
        int i4 = (z + add - 65) % 26;
        System.out.println((char) (65 + i4));

        // 字母前移
        int y = "b".codePointAt(0);
        int minus = 26;
        int i5 = (122 - y + minus) % 26;
        System.out.println((char) (122 - i5));
        int i6 = (y + (26 - minus) - 97) % 26; // 方法2
        System.out.println((char) (97 + i6));
    }
}

package 面试.算法;

/**
 * @author keenezhao
 * created in 2018/11/4 下午8:10
 */
public class 情况种类 {
    /*
    假设字符串中的所有字符不重复，如何输出字符串的所有组合，
    例如，输入字符串为“abc”，则输出a、b、c、ab、ac、bc、abc，共7种组合
     */

    private static void combineRecursive(char[] c, int begin, int len, StringBuffer sb) {
        if (len == 0) {
            System.out.print(sb + " ...");
            return;
        }
        if (begin == c.length) {
            return;
        }
        sb.append(c[begin]);
        System.out.print(sb + ",");
        combineRecursive(c, begin + 1, len - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb + ",");
        combineRecursive(c, begin + 1, len, sb);
    }

    public static void main(String[] args) {
        String s = "abc";
        char[] c = s.toCharArray();
        StringBuffer sb = new StringBuffer("");
        System.out.println(sb);

        int len = c.length;
        for (int i = 1; i <= len; i++) {
            combineRecursive(c, 0, i, sb);
        }
    }

}

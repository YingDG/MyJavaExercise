package 面试.算法;

/**
 * @author zdm
 * created in 2018/11/5 下午3:24
 */
public class 字符串 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        System.out.println(s1 == s2);
    }

    private static class SS {
        final char[] value;

        public SS(String str) {
            this.value = str.toCharArray();
        }

    }
}

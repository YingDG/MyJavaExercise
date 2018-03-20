package yingdg.exercise.se.stringtool;

/**
 * Created by yingdg on 2017/10/9 0009.
 */
public class 值传递与引用传递 {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    /*
    java只有值传递？
     */
    public static void main(String args[]) {
        值传递与引用传递 ex = new 值传递与引用传递();

        ex.change(ex.str, ex.ch);

        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok"; // String是final类
        ch[0] = 'g';
    }

}

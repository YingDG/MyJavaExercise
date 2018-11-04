package 面试.算法;

import java.util.Stack;

/**
 * @author keenezhao
 * created in 2018/11/4 下午8:15
 */
public class 栈排序 {
    /*
    按升序对栈进行排序，最多只能使用一个额外的栈存放临时数据，但不得将元素复制到另外的数据结构中（如数组）。
    该栈只支持如下操作：push、pop、peek和isEmpty
     */

    static Stack<Integer> sortStk(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!r.isEmpty() && r.peek() > temp) {
                s.push(r.pop());
            }
            r.push(temp);
        }
        return r;
    }

    public static void main(String[] args) {
        Stack<Integer> r = new Stack<>();
        r.push(5);
        r.push(4);
        r.push(3);
        r.push(1);
        r.push(2);

        System.out.println(sortStk(r));
    }

}

package yingdg.exercise.se.basicdatatype;

import java.util.LinkedList;
import java.util.List;

/**
 * @description 这个类是用 泛型实现的 数据存储栈
 * 栈数据结构 可以操作各种数据结构？？？
 */
public class MyStack<E> {
    private Node<E> top = new Node<>();

    //节点内部类
    private static class Node<E> {
        E item;
        Node<E> next;

        Node() {
            item = null;
            next = null;
        }

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    // 新元素添加到首位
    public MyStack<E> push(E item) {
        top = new Node<>(item, top);
        return this;
    }

    public E pop() {
        E result = top.item;

        if (!top.end()) {
            //假如这个内部类不是空的话把他付出里面的控制清空；这是要减少内存存储吗？
            //这句话才是真正的栈存储？
            top = top.next;
        }

        return result;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "top=" + top +
                '}';
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack
                .push("A").push("B").push("C")
                .pop(); // C,B,A --> B,A
        System.out.println(myStack);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.remove(1);
        System.out.println(linkedList);
    }
}

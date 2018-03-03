package yingdg.exercise.se.basicdatatype;

import java.util.Arrays;

/**
 * Created by yingdg on 2018/3/3.
 */
public class MyArray<E> {
    private Object[] array;
    private int size;
    private int capacity;

    public MyArray() {
        this.array = new Object[10];
    }

    public MyArray(int capacity) {
        this.array = new Object[capacity];
        this.capacity = capacity;
    }

    public MyArray<E> add(E e) {
        // 扩容
        if (size >= capacity) {
            capacity = capacity << 1;
            this.array = Arrays.copyOf(array, capacity);
        }

        array[size] = e;
        size++;
        return this;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MyArray<String> array = new MyArray<>(2);

        array.add("A").add("B").add("C");
        System.out.println(array);
    }
}

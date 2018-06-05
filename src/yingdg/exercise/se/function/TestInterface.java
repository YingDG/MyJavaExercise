package yingdg.exercise.se.function;

import java.util.function.Function;

/**
 * @author zdm
 * created in 2018/5/21 下午2:08
 */
public interface TestInterface {
    /*
    公有属性
     */
    String name = "test";

    String hello();

    /*
    默认方法
     */
    default void print() {
        System.out.println(name);
    }

    static void print2() {
        System.out.println("test2");
    }

    static void main(String[] args) {
        new TestInterImpl().print();
        TestInterface.print2();
        System.out.println(TestInterface.name);

        // 函数式编程
        System.out.println(((TestInterface) () -> "hello").hello()); // 接口只能有且只能有1个待实现方法
        System.out.println(((Function<Object, Boolean>) e -> true).apply(null));
    }

}

final class TestInterImpl implements TestInterface {

    @Override
    public String hello() {
        return null;
    }

//    @Override
//    public void print() {
//        System.out.println("impl");
//    }

}
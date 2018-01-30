package yingdg.exercise.se.reflect;

/**
 * Created by yingdg on 2017/8/9.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader.getClass());

        try {
            Class<?> obj = systemClassLoader.loadClass("java.lang.Object");
            System.out.println(obj.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ClassLoaderTest.class.getClassLoader());
    }
}


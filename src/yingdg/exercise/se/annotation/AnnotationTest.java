package yingdg.exercise.se.annotation;

import java.lang.annotation.Annotation;

/**
 * Created by yingdg on 2017/8/9.
 */
public class AnnotationTest {
    // 反射调用注解
    public static void main(String[] args) {
        Annotation[] annotations = Demo.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }
    }
}

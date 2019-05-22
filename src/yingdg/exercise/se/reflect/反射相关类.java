package yingdg.exercise.se.reflect;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author YingDG
 * created in 2019/5/22 4:27 PM
 */
public class 反射相关类 {
    public static void main(String[] args) {
        // 数组
        String[] o = (String[]) Array.newInstance(String.class, 2);
        o[0] = "hello";
        o[1] = "world";
        System.out.println(Arrays.toString(o));

        int declared = Member.DECLARED;

        boolean aFinal = Modifier.isFinal(0);


        // 动态代理(只能基于接口)：InvocationHandler,Proxy
        Proxy.newProxyInstance(反射相关类.class.getClassLoader(), new Class[]{Serializable.class}, null);

    }
}

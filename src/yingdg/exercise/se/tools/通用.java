package yingdg.exercise.se.tools;

import jdk.internal.util.EnvUtils;
import sun.misc.ThreadGroupUtils;

import java.beans.Beans;
import java.beans.ConstructorProperties;
import java.beans.DesignMode;
import java.beans.Transient;
import java.beans.beancontext.BeanContext;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryType;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.net.CookieHandler;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.util.Arrays;

/**
 * @author YingDG
 * created in 2019/5/22 2:19 PM
 */
public class 通用 {
    public static void main(String[] args) {
        Object globalHierarchyLock = BeanContext.globalHierarchyLock;
        String propertyname = BeanContext.PROPERTYNAME;
        String propertyname1 = DesignMode.PROPERTYNAME;

        try {
            Object instantiate = Beans.instantiate(通用.class.getClassLoader(), "java.lang.String");
            System.out.println(instantiate.getClass());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // todo ?
        int i = ThreadGroupUtils.getRootThreadGroup().activeCount();
        System.out.println(i);

        System.out.println(new Point(1, 2).getX());

        System.out.println(File.pathSeparator); // :
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator); // /
        System.out.println(File.separatorChar);

        System.out.println(Arrays.toString(ElementType.values()));

        int size = Character.SIZE; // 16

        Package aPackage = Package.getPackage("java.lang");
        System.out.println(aPackage);

        // 科学计算
        double sqrt = StrictMath.sqrt(4.0);
        System.out.println(sqrt);

        // 线程异常补获,实现Thread.UncaughtExceptionHandler接口
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        System.out.println(defaultUncaughtExceptionHandler); // null

        RoundingMode[] values = RoundingMode.values();
        System.out.println(Arrays.toString(values));

        CookieHandler aDefault = CookieHandler.getDefault();
        CookiePolicy acceptAll = CookiePolicy.ACCEPT_ALL;
        int httpOk = HttpURLConnection.HTTP_OK; //200

        Proxy.Type[] values1 = Proxy.Type.values();
        System.out.println(Arrays.toString(values1));
    }

    static class Point {
        @ConstructorProperties({"x", "y"}) // todo ?
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        @Transient // io时不序列化
        public int getY() {
            return y;
        }

        private final int x, y;
    }

}

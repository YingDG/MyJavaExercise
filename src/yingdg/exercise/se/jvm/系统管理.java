package yingdg.exercise.se.jvm;

import jdk.internal.util.EnvUtils;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryType;
import java.lang.management.OperatingSystemMXBean;
import java.util.Arrays;

/**
 * @author YingDG
 * created in 2019/5/22 4:28 PM
 */
public class 系统管理 {
    public static void main(String[] args) {
        // jvm管理类
        String classLoadingMxbeanName = ManagementFactory.CLASS_LOADING_MXBEAN_NAME;
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println(classLoadingMXBean.getTotalLoadedClassCount());
        System.out.println(Arrays.toString(MemoryType.values()));
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(operatingSystemMXBean.getName());

        // 获取系统环境变量
        String java_home = EnvUtils.getEnvVar("JAVA_HOME");
        System.out.println(java_home);

        // todo ?
        Compiler.compileClass(Object.class);

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory()/1024/1024); // jvm空闲内存，单位MB

        SecurityManager securityManager = System.getSecurityManager(); // null


    }
}

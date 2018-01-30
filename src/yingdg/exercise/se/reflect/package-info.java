/**
 * Created by yingdg on 2017/8/9.
 */
package yingdg.exercise.se.reflect;

/*
反射高级

3个ClassLoader,系统内置的ClassLoader通过双亲委托来加载指定路径下的class和资源。

BootStrap ClassLoader：
    称为启动类加载器，是Java类加载层次中最顶层的类加载器，负责加载JDK中的核心类库，
    如：rt.jar、resources.jar、charsets.jar等

Extension ClassLoader：
    称为扩展类加载器，负责加载Java的扩展类库，
    默认加载JAVA_HOME/jre/lib/ext/目下的所有jar

App ClassLoader：
    称为系统类加载器，负责加载应用程序classpath目录下的所有jar和class文件


环境变量

JAVA_HOME

PATH=%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;%PATH%;

CLASSPATH=.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar

echo指令查看
 */
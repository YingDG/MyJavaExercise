/**
 * Created by yingdg on 2017/8/9.
 */
package yingdg.exercise.se.annotation;

/*
Java注解开发

@Documented
是否会保存到 Javadoc 文档中

@Retention 保留时间，
可选值 SOURCE（源码时），CLASS（编译时），RUNTIME（运行时），默认为 CLASS。

如果是SOURCE，注解保留范围为源代码，在编译时将会被编译器丢弃。这类 Annotation 大都用来校验，比如 Override, Deprecated, SuppressWarnings。
如果是CLASS，这个注解保留范围是源代码和类文件中，但并非作用于运行时，所以JVM不会识别此。如果你在自定义注解时，不写@Retention，默认就是CLASS的。这类的注解和SOURCE的注解都可以配合AbstractProcessor进行使用，用于在编译时进行自动处理一些事物或者生成一些文件。
如果是RUNTIME，这个注解的保留范围是源代码、类文件和运行时，这类的注解一般会和反射配合使用。可以在运行时通过反射查看被这个注解标识的方法，然后得到被标识的元素，接着进行处理

@Target 来指定这个注解可以修饰哪些元素，
如 TYPE, METHOD, CONSTRUCTOR, FIELD, PARAMETER 等，未标注则表示可修饰所有类型

@Inherited
是否可以被继承，默认为 false

 */
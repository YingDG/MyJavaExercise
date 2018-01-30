package yingdg.exercise.se.generics;

import java.lang.reflect.ParameterizedType;

/**
 * Created by yingdg on 2017/9/1 0001.
 * <p>
 * 泛型实例化
 */
public class InstanceGet implements IInstanceGet<User> {
    private Class<?> t;

    public InstanceGet() {
        // 继承泛型抽象类
//        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
//        t = (Class<?>) type.getActualTypeArguments()[0];
//        set(t);

        // 实现泛型接口
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericInterfaces()[0];
        String typeName = type.getActualTypeArguments()[0].getTypeName();
//        t = (Class<?>) type.getActualTypeArguments()[0];
        try {
            t = Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public InstanceGet(Class<User> t) {
        set(t);
    }

    private void set(Class<User> t) {
        this.t = t;
    }

    @Override
    public User getInstance() {
        try {
            return (User) t.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        IInstanceGet<User> objectGet = new InstanceGet(User.class);
        User user = objectGet.getInstance();
        user.setName("user");
        System.out.println(user);

        IInstanceGet<User> objectGet2 = new InstanceGet();
        User user2 = objectGet2.getInstance();
        user2.setName("user2");
        System.out.println(user2);
    }
}

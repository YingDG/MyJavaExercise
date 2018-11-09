package yingdg.exercise.se.event.observer;

/**
 * @author yingdg
 * created in 2018/11/9 下午1:36
 */
public class MyObserverMain {
    public static void main(String[] args) {
        MyObserverManager manager = new MyObserverManager();

        manager.addObserver((MyObserver) (o, arg) -> {
            MyObserverObject obj = new MyObserverObject(o, arg); // 强转类型必须在赋值之前
            System.out.println(obj.getValue());
        });
        manager.addObserver((o, arg) -> {
            MyObserverObject obj = new MyObserverObject(o, arg);
            System.out.println(obj.getValue().toString() + " II");
        });

        manager.setChanged();
        manager.notifyObservers("hello, sb java"); // 倒序通知
    }
}

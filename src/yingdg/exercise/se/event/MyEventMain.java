package yingdg.exercise.se.event;

/**
 * @author yingdg
 * created in 2018/11/9 上午11:12
 */
public class MyEventMain {
    public static void main(String[] args) {
        MyEventManager manager = new MyEventManager();
        manager.addDoorListener(new MyEventListenerImpl());// 给门1增加监听器
        manager.addDoorListener(event -> {
            if (event.getDoorState() != null && event.getDoorState().equals("open")) {
                System.out.println("门2打开，同时打开走廊的灯");
            } else {
                System.out.println("门2关闭，同时关闭走廊的灯");
            }
        });// 给门2增加监听器

//        manager.removeDoorListener(myEventListenerImpl2);

        // 开门
        manager.fireWorkspaceOpened();
        System.out.println("我已经进来了");

        // 关门
        manager.fireWorkspaceClosed();
    }
}

package yingdg.exercise.se.event;

/**
 * @author yingdg
 * created in 2018/11/9 上午11:07
 */
public class MyEventListenerImpl implements MyEventListener {

    @Override
    public void doorEvent(MyEventObject event) {
        if (event.getDoorState() != null && event.getDoorState().equals("open")) {
            System.out.println("门1打开");
        } else {
            System.out.println("门1关闭");
        }
    }

}

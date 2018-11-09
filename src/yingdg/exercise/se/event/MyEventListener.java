package yingdg.exercise.se.event;

import java.util.EventListener;

/**
 * @author yingdg
 * created in 2018/11/9 上午10:53
 */
@FunctionalInterface
public interface MyEventListener extends EventListener {

    void doorEvent(MyEventObject event);

}

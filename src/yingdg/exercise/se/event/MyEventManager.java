package yingdg.exercise.se.event;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author yingdg
 * created in 2018/11/9 上午11:08
 */
public class MyEventManager {
    private Collection listeners;

    /**
     * 添加事件
     */
    public void addDoorListener(MyEventListener listener) {
        if (listeners == null) {
            listeners = new HashSet();
        }
        listeners.add(listener);
    }

    /**
     * 移除事件
     */
    public void removeDoorListener(MyEventListener listener) {
        if (listeners == null) {
            return;
        }
        listeners.remove(listener);
    }

    /**
     * 触发开门事件
     */
    protected void fireWorkspaceOpened() {
        if (listeners == null) {
            return;
        }
        MyEventObject event = new MyEventObject(this, "open");
        notifyListeners(event);
    }

    /**
     * 触发关门事件
     */
    protected void fireWorkspaceClosed() {
        if (listeners == null) {
            return;
        }
        MyEventObject event = new MyEventObject(this, "close");
        notifyListeners(event);
    }

    /**
     * 通知所有的Listener
     */
    private void notifyListeners(MyEventObject event) {
        listeners.forEach(e -> ((MyEventListener) e).doorEvent(event));
    }

}

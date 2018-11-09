package yingdg.exercise.se.event;

import java.util.EventListenerProxy;

/**
 * @author yingdg
 * created in 2018/11/9 下午12:56
 */
public class MyEventListenerProxy extends EventListenerProxy<MyEventListener> {
    private String status;

    /**
     * Creates a proxy for the specified listener.
     *
     * @param listener the listener object
     */
    public MyEventListenerProxy(MyEventListener listener) {
        super(listener);
    }

    public MyEventListenerProxy(MyEventListener listener, String status) {
        super(listener);
        this.status = status;
    }

}

package yingdg.exercise.se.event.observer;

import java.io.Serializable;
import java.util.EventObject;

/**
 * @author yingdg
 * created in 2018/11/9 下午1:40
 */
public class MyObserverObject extends EventObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private Object value;

    public MyObserverObject(Object source, Object value) {
        super(source);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}

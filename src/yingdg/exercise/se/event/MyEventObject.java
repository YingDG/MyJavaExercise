package yingdg.exercise.se.event;

import java.util.EventObject;

/**
 * @author yingdg
 * created in 2018/11/9 上午11:04
 */
public class MyEventObject extends EventObject {
    private static final long serialVersionUID = 1L;
    private String doorState = "";// 表示门的状态，有“开”和“关”两种

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MyEventObject(Object source) {
        super(source);
    }

    public MyEventObject(Object source, String doorState) {
        super(source);
        this.doorState = doorState;
    }

    public String getDoorState() {
        return doorState;
    }

    public void setDoorState(String doorState) {
        this.doorState = doorState;
    }

}

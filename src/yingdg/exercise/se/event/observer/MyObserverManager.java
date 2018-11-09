package yingdg.exercise.se.event.observer;

import java.util.Observable;

/**
 * @author yingdg
 * created in 2018/11/9 下午1:37
 */
public class MyObserverManager extends Observable {

    public MyObserverManager() {
        super();
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    protected synchronized void clearChanged() {
        super.clearChanged();
    }

}

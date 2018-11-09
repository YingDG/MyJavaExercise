package yingdg.exercise.se.event.observer;

import java.util.EventListener;
import java.util.Observer;

/**
 * @author yingdg
 * created in 2018/11/9 下午1:32
 */
@FunctionalInterface
public interface MyObserver extends Observer, EventListener {
}

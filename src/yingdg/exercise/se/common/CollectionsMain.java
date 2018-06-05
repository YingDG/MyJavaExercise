package yingdg.exercise.se.common;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zdm
 * created in 2018/6/5 下午2:22
 */
public class CollectionsMain {
    public static void main(String[] args) {
        List<Object> emptyList = Collections.emptyList();
        Map emptyMap = Collections.EMPTY_MAP;

        Set set = Collections.newSetFromMap(emptyMap);
    }
}

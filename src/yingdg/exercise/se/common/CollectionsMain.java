package yingdg.exercise.se.common;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author zdm
 * created in 2018/6/5 下午2:22
 */
public class CollectionsMain {
    public static void main(String[] args) {
//        List<Object> emptyList = Collections.emptyList();
//        Map emptyMap = Collections.EMPTY_MAP;
//
//        Set set = Collections.newSetFromMap(emptyMap);

        Map<Object, Object> map = new HashMap<>();
        map.put(null, 1);
        System.out.println(map.get(null));

        Map<Object, Object> hashtable = new Hashtable<>(); // k,v都不能为null
        hashtable.put(null, 1);
//        hashtable.put(1, null);
    }
}

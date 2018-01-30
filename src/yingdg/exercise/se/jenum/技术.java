package yingdg.exercise.se.jenum;

/**
 * Created by yingdg on 2017/8/9.
 */
public enum 技术 {
    FRAME("架构师", 1), FRONTEND("前端", 2), BACKEND("后端", 3), DBA("数据库管理员", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    技术(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (技术 c : 技术.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "技术{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

}

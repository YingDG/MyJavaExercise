package yingdg.exercise.se.jenum;

/**
 * Created by yingdg on 2017/8/9.
 */
public enum 部门 implements IPrint {
    市场部("市场部", 1), 开发部("开发部", 2);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    部门(String name, int index) {
        this.name = name;
        this.index = index;
    }


    @Override
    public void myPrint() {
        System.out.println(this.name + this.index);
    }
}

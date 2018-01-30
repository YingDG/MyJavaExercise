package yingdg.exercise.se.sort;

import java.util.Arrays;

/**
 * Created by yingdg on 2017/10/16 0016.
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] a = {20, 12, 5, 16, 15, 1, 30, 45, 23, 9};
        System.out.println("初始数组：" + Arrays.toString(a));

        // 排序
        insertSort(a);

        System.out.println("最终数组：" + Arrays.toString(a));
    }

    public static void insertSort(int[] arr) {
        int i, j;
        int target;

        /*
        假定第一个元素被放到了正确的位置上
        这样，仅需遍历1 - n-1
         */
        for (i = 1; i < arr.length; i++) {
            j = i;
            target = arr[i];

            // 所有元素后移
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;

            System.out.println(Arrays.toString(arr));
        }
    }

}

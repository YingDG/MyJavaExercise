package yingdg.exercise.se.sort;

import java.util.Arrays;

/**
 * Created by yingdg on 2017/10/16 0016.
 */
public class 快速排序 {
    private static final int[] NUM = {2, 5, 7, 9, 4, 3, 1, 7};
    // 循环次数标记
    private static int count = 1;

    /*
    通过一趟排序将要排序的数据分割成独立的两部分，
    其中一部分的所有数据都比另外一部分的所有数据都要小，
    然后再按此方法对这两部分数据分别进行快速排序，
    整个排序过程可以递归进行，以此达到整个数据变成有序序列
     */
    public static void main(String[] args) {
        int[] a = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        System.out.println("初始数组：" + Arrays.toString(a));

        int start = 0;
        int end = a.length - 1;
        // 排序
        quickSort(a, start, end);

        System.out.println("最终数组：" + Arrays.toString(a));
    }

    public static void quickSort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        // 基准值
        int key = a[low];

        while (end > start) {
            // 1.从后往前比较
            /*
            如果没有比基准值小的，比较下一个，直到有比基准值小的交换位置，然后又从前往后比较
             */
            while (end > start && a[end] >= key) {
                end--;
            }
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            System.out.println("第" + count + "次从后往前比较：" + Arrays.toString(a));

            // 2.从前往后比较
            /*
            如果没有比基准值大的，比较下一个，直到有比基准值大的交换位置
             */
            while (end > start && a[start] <= key) {
                start++;
            }
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            System.out.println("第" + count + "次从前往后比较：" + Arrays.toString(a) + "\n");
            count++;
        }

        /*
        此时第一次循环比较结束，基准值的位置已经确定了。
        左边的值都比基准值小，右边的值都比基准值大，但是两边的顺序还有可能是不一样的，
        进行下面的递归调用
         */

        //递归
        if (start > low) { // 左边序列。第一个索引位置到关键值索引-1
            quickSort(a, low, start - 1);
        }
        if (end < high) { // 右边序列。从关键值索引+1到最后一个
            quickSort(a, end + 1, high);
        }
    }

}

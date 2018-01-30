package yingdg.exercise.se.sort;

import java.util.Arrays;

/**
 * Created by yingdg on 2017/10/16 0016.
 */
public class 希尔排序 {
    /*
    希尔排序也成为“缩小增量排序”，其基本原理是，
    现将待排序的数组元素分成多个子序列，使得每个子序列的元素个数相对较少，
    然后对各个子序列分别进行直接插入排序，待整个待排序列“基本有序”后，
    最后在对所有元素进行一次直接插入排序。
     */
    public static void main(String[] args) {
        int[] data = new int[]{26, 53, 67, 48, 57, 13, 48, 32, 60, 50};

        shellSortSmallToBig(data);

        System.out.println(Arrays.toString(data));
    }

    public static void shellSortSmallToBig(int[] data) {
        int j, temp;

        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);

            for (int i = increment; i < data.length; i++) {
                // System.out.println("i:" + i);

                temp = data[i];

                for (j = i - increment; j >= 0; j -= increment) {
                    // System.out.println("j:" + j);
                    // System.out.println("temp:" + temp);
                    // System.out.println("data[" + j + "]:" + data[j]);
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }

                data[j + increment] = temp;
            }

            System.out.println(Arrays.toString(data));
        }
    }

}

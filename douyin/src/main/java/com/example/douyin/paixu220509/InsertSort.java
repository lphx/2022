package com.example.douyin.paixu220509;

import java.util.Arrays;

/**
 * @ClassName: InsertSort
 * @Author: lph
 * @Description:
 * @Date: 2022/5/9 23:55
 */
public class InsertSort {

    public static void main(String[] args) {

    }


    /**
     * 插入排序
     * @param arr 进行排序的数组
     * @return 排好序的数组
     */
    public static int[] insertSort(int[] arr) {
        //要插入的值
        int insertValue;
        //插入的下标
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            //先从已经排好序的数组中最后一个数开始比较
            insertIndex = i - 1;
            //如果下标小于0了说明已经跟 已排好序的数组全部做过了比较
            //如果要插入的那个值 小于 已排好序的数组中最后一个 九将这个数后移以为 然后在往前遍历 依此比较
            //知道找到一个比要插入值小的 则该点就是要插入的点
            //如果一次while循环也没进入 则说明要插入的这个值比 已排好序的数组中所有的都要大
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //将值插入
            arr[insertIndex + 1] = insertValue;

            System.out.println("第" + i +"次遍历排序:");
            System.out.println(Arrays.toString(arr));
        }

        return arr;
    }

}

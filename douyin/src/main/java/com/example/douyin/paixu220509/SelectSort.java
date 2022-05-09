package com.example.douyin.paixu220509;

/**
 * @ClassName: SelectSort
 * @Author: lph
 * @Description:
 * @Date: 2022/5/9 23:54
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4};
        selectSort(arr);
    }


    /**
     * 选择排序
     * @param arr 进行排序的数组
     * @return 排好序的数组
     */
    public static int[] selectSort(int[] arr) {
        int temp = 0;
        //最小值的下标
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //先假设最小的数是arr[i]
            min = i;
            //遍历找到最小的那个
            for (int j = i + 1; j < arr.length; j++) {
                //如果发现arr[j] 比 arr[min]小 则令min = j
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            //将的到的最小值与arr[i]进行交换
            if (min != i) {
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }


}

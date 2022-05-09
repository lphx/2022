package com.example.douyin.paixu220509;

/**
 * @ClassName: QuickSort
 * @Author: lph
 * @Description:
 * @Date: 2022/5/9 23:57
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    //快速排序
    public static void quickSort(int[] arr, int star, int end) {
        if (star >= end) {
            return ;
        }
        int l = star;
        int r = end;
        int piovt = arr[(l + r)/2];
        while (l <= r) {
            while (l <= r && arr[l] < piovt) {
                l++;
            }
            while (l <= r && arr[r] > piovt) {
                r--;
            }
            //交换
            if (l <= r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        quickSort(arr,star,r);
        quickSort(arr,l,end);

    }




}

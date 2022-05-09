package com.example.douyin.paixu220509;


public class MergeSort {
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr,0, arr.length-1, temp);
    }
 

    // 归并排序
    public static void mergeSort(int[] arr, int star, int end, int[] temp) {
        if (star >= end) {
            return;
        }
        int mid = star + (end - star) / 2;
        //分
        mergeSort(arr, star, mid, temp);
        mergeSort(arr, mid + 1, end, temp);
        
        //治
        merge(arr,star,mid,end,temp);
    }
 
    private static void merge(int[] arr, int star, int mid, int end, int[] temp) {
        int left = star;
        int right = mid + 1;
        int index = star;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= end) {
            temp[index++] = arr[right++];
        }
        for (int i = 0; i <= end; i++) {
            arr[i] = temp[i];
        }
    }
}
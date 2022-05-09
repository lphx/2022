package com.example.douyin.paixu220509;

/**
 * @ClassName: HeapSort
 * @Author: lph
 * @Description:
 * @Date: 2022/5/10 0:00
 */
public class HeapSort {


    /**
     * 堆排序
     * @param arr 待排序数组
     * @return 有序数组
     */
    public static int[] heapSort(int[] arr) {
        int temp = 0;
        //把无序数组 变成大顶堆
        for (int i = arr.length/2 -1; i >= 0; i--) {
            max2Root(arr, i, arr.length);
        }
//        System.out.println(Arrays.toString(arr));
        //将堆顶元素与末尾元素交换,将最大元素"沉"到数组末端;
        //重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //把剩下数组继续变成大顶堆
            max2Root(arr, 0, j);
        }
        return arr;
    }

    /**
     * 将数组变成大顶堆
     * @param arr 待排序数组
     * @param i 父节点下标
     * @param lenght 数组长度
     */
    public static void max2Root(int[] arr, int i, int lenght) {
        int temp = arr[i];
        //将最大值与父节点交换
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            //如果左子节点大于右子节点 则k指向右子节点
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {
                k = k + 1;
            }
            //如果父节点 小于 最大的子节点
            if (temp < arr[k]) {
                arr[i] = arr[k];
                //让i指向k 继续循环
                i = k;
            } else {
                //父节点就是最大的了 直接退出
                break;
            }
        }
        //将 temp放到调整后的位置
        arr[i] = temp;
    }


}

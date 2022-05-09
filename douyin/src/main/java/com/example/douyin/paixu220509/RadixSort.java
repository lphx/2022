package com.example.douyin.paixu220509;

/**
 * @ClassName: RadixSort
 * @Author: lph
 * @Description:
 * @Date: 2022/5/9 23:59
 */
public class RadixSort {


    /**
     * 基数排序
     * @param arr 待排序数组
     * @return 排好序的数组
     */
    public static int[] radixSort(int[] arr) {
        int max = arr[0];
        //遍历出数组的最大值
        for (int t = 0; t < arr.length; t++) {
            if (max < arr[t]) {
                max = arr[t];
            }
        }
        //最大位数
        int digit = (max+"").length();
        //创建一个二维数组 模拟10个桶 分别装 0 1 2 3 4 5 6 7 8 9
        int[][] bucket = new int[10][arr.length];
        //用来记录桶中存放了几个数据  比如bucketElementCounts[2] = 3; 就代表存放2的那个桶中有3个数据
        int[] bucketElementCounts = new int[10];
        int temp;
        //个 十 百 位....只到遍历到最高位
        for (int w = 0; w < digit; w++) {
            //放进对应的桶中
            for (int i = 0; i < arr.length; i++) {
                //获取对应的位的值 比如第一次就是取个位的值 然后再取十位的值 以此类推
                temp = (int) (arr[i] / ( Math.pow(10,w)) % 10);
                //放进对应的桶中
                bucket[temp][bucketElementCounts[temp]] = arr[i];
                //记录桶中存放元素的个数++
                bucketElementCounts[temp]++;
            }
            //当做遍历arr的索引
            int index = 0;
            //从桶中依次放进arr中 j代表哪个桶
            for (int j = 0; j < 10; j++) {
                //如果桶中有数据在遍历
                if(bucketElementCounts[j] != 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        //取出元素放在arr中
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                //遍历完一个桶后 要把记录桶中数据的个数清零 要不然会影响下一次的存放
                bucketElementCounts[j] = 0;
            }
        }
        return arr;
    }


}

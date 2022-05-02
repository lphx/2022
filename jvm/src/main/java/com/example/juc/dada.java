package com.example.juc;

/**
 * @ClassName: dada
 * @Author: lph
 * @Description:
 * @Date: 2022/4/25 21:14
 */
public class dada {

    public static void main(String[] args) {
        int arr[] = {5,2,6,3,1,7};

        System.out.println(qzd(arr,arr.length-1));
    }

    private static int qzd(int arr[],int i){
        if (i == 0){
            return arr[0];
        }else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        }else {
            int xz = qzd(arr,i-2) + arr[i];
            int bx = qzd(arr,i-1);
            return Math.max(xz, bx);
        }
    }
}

package com.sunrui;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr.length < 2 ||arr == null){
            return;
        }
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i; j++){
                /*
                从第0号下标开始，向最后一个来寻找最大第值放到最右边，
                多重循环先从最里面开始看，那么这里代表的就是从0到n-1再从0到n-2
                 */
                if(arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }

    //交换arr的i和j位置上的值
    public static void swap(int[] arr ,int i ,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //for test
    public static void main(String[] args) {
        int[] arrays={1,22,3,23,32,12,45};
        bubbleSort(arrays);
        for (int a: arrays
             ) {
            System.out.println(a);
        }
    }
}

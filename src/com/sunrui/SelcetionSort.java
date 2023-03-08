package com.sunrui;

import java.util.Arrays;

public class SelcetionSort {
    public static void selectionSort(int[] array){
        if(array == null || array.length<=2){
            return;
        }
        for(int i = 0; i < array.length; i++){
            /*选择排序的思想就是：
            首先从0到n-1之间选出最小的数字，并将其放在首位
            接着继续从1到n-1之间继续选择，直到选到最后
            minIndex代表选出的下标
             */
            int minIndex = i;
            for(int j = i+1;j < array.length; j++){
                //这一步其实就是双重循环进行选择
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            swap(i,minIndex,array);
        }

    }
    public static void swap(int i, int j , int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arrays={1,22,3,23,32,12,45};
        selectionSort(arrays);
        for (int a:arrays
             ) {
            System.out.println(a);
        }
    }
}

package com.sunrui;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        if(arr.length < 2 ||arr == null){
            return;
        }
        //0-1是有序的，0-i想有序
        for(int i = 0; i < arr.length; i++){
            for(int j = i-1; j >= 0 &&arr[j]>arr[j+1]; j--){
                swap(arr,j,j+1);
            }
        }
    }
    public static void swap(int[] arr ,int i ,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void compataror(int[] arr){
        Arrays.sort(arr);  //系统提供的排序，当作对数器的方法B
    }

    //for test
    public static int[] generateRandomArray(int maxSize,int maxValue){
        //Math.random(): [0,1）之间的所有小数，等概率随机返回一个
        //Math.random*N: [0,N)之间的所有小数，等概率随机返回一个
        //int(Math.random*N):[0,N-1)之间的所有整数，等概率随机返回一个
        int arr[] = new int[((int)((maxSize+1)*Math.random()))];  //长度随机
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)((maxValue+1)*Math.random())-(int)((maxValue)*Math.random());

        }
        return arr;
    }

    //for test
    public static int[] copyArray(int[] arr){
        if(arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

    //for test
    public static boolean isEuqul(int[] arr1,int[] arr2){
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if(arr1 == null && arr2 == null){
            return true;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    //for test
    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for (int i:arr
             ) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            compataror(arr2);
            if(!isEuqul(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked!");

    }

}

package com.sunrui;

public class Code06_QuickSort {
    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr , 0 , arr.length-1);
    }

    /**arr[L...R]排序好
     *
     * @param arr
     * @param L
     * @param R
     * 第一步等概率随机算一个位置，把他跟基准数（最右侧的数）做交换
     * 然后在L，R范围上做partition
     * 返回的数组长度一定为2
     * p[0]是等于区域的左边界，-1即是小于区的右边界，然后递归
     * P[1]是等于区的右边界，+1即是大于区左边界，然后递归
     */
    public static void quickSort(int[] arr , int L , int R){
        if(L < R){
            swap(arr , L + (int)(Math.random()*(R-L+1)),R);
            int[] p = partition(arr , L , R);
            quickSort(arr , L , p[0]-1);  //小于区
            quickSort(arr , p[1]+1 , R);  //大于区
        }
    }

    /**这是一个处理arr[L...R]的函数，
     * 默认以arr[R]做划分（基准数），arr[R] -> p   <p    ==p    >p
     * 返回等于区域（左边界，右边界）所以返回一个长度为2的数组res，res[0]，res[1]
     */
    public static int[] partition(int[] arr , int L , int R) {
        int less = L - 1;  //小于区右边界
        int more = R;  //大于区左边界
        while (L < more) {  //L表示当前数的位置 arr[R] -> 基准数
            if (arr[L] < arr[R]) { //当前值小于基准数
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {  //当前值大于基准数
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr , more , R);
        return new int[] {less + 1 , more };
    }
    public static void swap(int[] arr , int i , int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

package com.sunrui;

public class Code02_SmallNum {
    public static int smallSum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }

    //arr[L..R]既要排好序也要求小和
    public static int process(int[] arr ,int L ,int R){
        if(L == R){ //终止条件
            return 0;
        }
        int mid = L + ((R-L) >> 1); //中点
        return process(arr, L ,mid) +process(arr, mid+1 ,R) +merge(arr,L,mid,R);
    }
    public static int merge(int[] arr, int L, int R, int M){
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        int res = 0;
        while (p1 <= M && p2 <= R){
            /*都不越界的时候只有左边比右边小的时候，
             R-p2+1指的是当前有多少个比左边的大，然后乘上这个小数，
             如果不比右边的小，就是0。
             */
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] <=arr[p2] ? arr[p1++] :arr[p2++];
        }
        while(p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for(i = 0; i<help.length; i++){
            arr[L + i] = help[i];
        }
        return res;
    }
}

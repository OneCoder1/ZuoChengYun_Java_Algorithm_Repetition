package com.sunrui;

public class Code08_GetMax {
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    //arr从L到R的范围求最大值
    public static int process(int[] arr ,int L ,int R){
        if(L == R){ //终止条件
            return arr[L];
        }
        int mid = L + ((R-L) >> 1); //中点
        int leftMax = process(arr, L ,mid);
        int rightMax = process(arr, mid+1 ,R);
        return Math.max(leftMax,rightMax);
    }
}

package com.sunrui;

public class Code02_RadixSort {

    //only for no-negative value
    public static void radisSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length ; i++){
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while (max != 0){
            res++;
            max /= 10;
        }
        return res;
    }

    //arr[begin...end]排序
    public static void radixSort(int[] arr, int L, int R, int dight){
        //以10为基底
        final int radix = 10;
        int i = 0,j = 0;
        //有多少个数准备多少个辅助空间
        int[] bucket = new int[R-L+1];
        /*
        有多少位就进出几次：代表出桶入桶多少次，跟位数有关（最大的for循环的意思）
        十个空间
        count[0]  当前位(d位)是0的数字有多少个
        count[1]  当前位(d位)是(0和1)的数字有多少个
        count[2]  当前位(d位)是(0,1,3)的数字有多少个
        count[i]  当前位(d位)是(0~i)的数字有多少个
         */
        for(int d = 1; d <= dight; d++){
            int[] count = new int[radix];
            for(i = L; i <= R; i++){
                j = getDight(arr[i],d);
                count[j]++;
            }
            for(i = 1; i < radix; i++){
                count[i] = count[i] + count[i-1];
            }
            for(i = R; i >= L; i--){
                j = getDight(arr[i],d);
                bucket[count[j]-1] = arr[i];
                count[j]--;
            }
            for(i = L, j = 0; i <= R; i++, j++){
                arr[i] = bucket[j];
            }
        }
    }

    public static int getDight(int x, int d){
        return ((x / ((int)Math.pow(10,d-1)))%10);
    }


}

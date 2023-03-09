package com.sunrui;

import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {
    /**
     * 问题描述：数字所在的位置和他排完序应该在的位置不超过k
     * @param arr
     * @param k
     */
    public void sortedArrayDistanceLessK(int[] arr , int k){
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        //先把前k个数放到小根堆
        for( ; index <= Math.min(arr.length, k) ; index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for( ; index < arr.length ; i++ , index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {

    }
}

package com.sunrui;

public class Code03_HeapSort {
    /**
     * @param arr
     */
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
//        for(int i =0; i < arr.length; i++){
//            heapInsert(arr , i);
//        }

        //从下到上的成大根堆的方法，时间复杂度为O(N)
        for(int i = arr.length -1 ; i >= 0 ; i--){
            heapify(arr , i , arr.length);
        }
        int heapSize = arr.length;
        swap(arr , 0 , --heapSize);
        while (heapSize > 0){
            heapify(arr , 0 ,heapSize);
            swap(arr , 0 , --heapSize);
        }
    }

    /**
     * @param arr
     * @param index
     * 某个数现在处在index位置，继续往上移动
     * 这里的while语句其实包含了两个意思：
     * 1. 只有当当前节点比父节点小的时候才会停止，如果大的话继续
     * 2. 或者当当前节点变成头节点，也就是（index-1）/2等于0的时候，arr[index]==arr[(index-1)/2]，也会停止
     */
    public static void heapInsert(int[] arr ,int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr , index , arr[(index - 1)/2]);
            index = (index - 1)/2;
        }
    }

    /**
     * @param arr
     * @param index
     * @param heapSize
     * 某个数在index位置能否往下移动，index是指从哪个位置开始往下做heapift（堆化）
     * left代表左孩子下标。heapSize代表这个数组的大小，left<heapSize判断是否越界代表下方还有孩子
     * left加一就是右孩子，两个孩子中谁的值更大，就把他的下标存放在largest中
     * 然后再次跟父节点比较，谁大将谁的下标存放在largest中，注意这个时候index就是父
     */
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while(left < heapSize){
            int largest = left + 1 <heapSize && arr[left+1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr , index ,largest);
            index = largest;
            left = index * 2 + 1;
        }

    }

    public static void swap(int[] arr , int i , int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

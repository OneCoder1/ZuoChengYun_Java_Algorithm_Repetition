package com.sunrui;

public class Code01_EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr){
        //已知在一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这个数字
        int eor = 0;
        for(int cur : arr){
            eor ^= cur;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr){
        //已知在一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数字
        int eor = 0 , onlyOne = 0;
        for(int curNum : arr){
            eor ^= curNum;
        }
        /*
        eor = a ^ b;
        eor != 0
        eor必然至少有一个位置上是1
        RightOne是最右边为1 的
         */
        int RightOne = eor & (~eor + 1);
        for(int cur : arr){
            if((cur & RightOne) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}

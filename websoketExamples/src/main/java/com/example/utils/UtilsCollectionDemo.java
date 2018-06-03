package com.example.utils;

import java.util.*;

/**
 * Created by fangqing on 6/3/18.
 */
public class UtilsCollectionDemo {


    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(8);
        nums.add(-3);
        nums.add(2);
        nums.add(9);
        nums.add(-2);
        System.out.println("original is:" + nums);
        Collections.reverse(nums);
        System.out.println("reverse  is:" + nums);
        Collections.sort(nums);
        System.out.println("sorted is:" + nums);
        Collections.shuffle(nums);
        System.out.println("after shuffler is:" + nums);
//        自定义排序
        Collections.sort(nums, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                // TODO Auto-generated method stub
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return s1.compareTo(s2);
            }

        });
        System.out.println("sort by my define is:" + nums);

// 最大最小 频率 二分查找


        System.out.println("original is :" + nums);
        System.out.println(Collections.max(nums));
        System.out.println(Collections.min(nums));
        Collections.replaceAll(nums, -3, 3);
        System.out.println(Collections.frequency(nums, 3));
        Collections.sort(nums);
        System.out.println(Collections.binarySearch(nums, 2));
        System.out.println(nums);


//        线程同步

        Collection c = Collections.synchronizedCollection(new ArrayList());
        List list = Collections.synchronizedList(new ArrayList());
        Set s = Collections.synchronizedSet(new HashSet());
        Map m = Collections.synchronizedMap(new HashMap());

    }
}

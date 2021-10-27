package com.example.demo.service.buillder;

import java.util.Date;

/**
 * @author ranran.mao
 * @date 2021/8/25 17:26
 */
public class Solution {
    public int search(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={-1,0,3,5,9,12};
        int target=2;
        int search = solution.search(nums, target);
        System.out.println(search);
        Date nextDay = Solution.getNextDay();
        System.out.println(nextDay.toString());
    }

    /**
     * 获取下一个日期时间
     * @return
     */
    public static Date getNextDay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}

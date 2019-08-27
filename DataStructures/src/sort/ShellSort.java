package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {-1, -5, 5, 8, 2, 3};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void shellSort(int[] nums){
        int temp = 0;
        int count = 0;

        //几次分组
        for (int groupNum = nums.length/2; groupNum > 0; groupNum /= 2){
            //分完组后，循环每一组
            for (int i = groupNum; i < nums.length; i++){
                //遍历这一组，进行元素交换
                for (int j = i - groupNum; j >= 0; j-=groupNum){
                    if (nums [j] > nums [j+groupNum]){
                        temp = nums [j];
                        nums [j] = nums [j+groupNum];
                        nums [j+groupNum] = temp;
                    }
                }
            }
            System.out.println("希尔排序" + (++count) + "轮排序结果 = " + Arrays.toString(nums));
        }
    }
}

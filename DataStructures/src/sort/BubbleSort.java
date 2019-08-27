package sort;

/**
 * 冒泡排序
 * 每次遍历遇到比当前数值大的就交换，一次结束后数组最后元素就是最大值
 * 以此类推
 *
 * 优化冒泡就是发现已经排好序的数组就不往下进行继续判断，直接跳出
 * @author wannengqingnian
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {-1, -5, 5, 8, 2, 3};
        bubble(nums);

        for(int n : nums){
            System.out.print(n + " ");
        }
    }


    public static void bubble(int[] nums){
        int length = nums.length - 1;
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < length; i++){
            //为什么要nums.length - 1 最后一遍不需要再排，已经是有序的， -i 是从i开始往后都是有序的
            for (int j = 0; j < length - i; j++){
                if (nums[j] > nums[j+1]){
                    flag = true;
                    temp = nums [j];
                    nums [j] = nums [j+1];
                    nums [j+1] = temp;
                }
            }
            if (!flag){
                break;
            }else {
                 flag = false;
            }
        }
    }


}

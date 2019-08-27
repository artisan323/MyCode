package sort;

/**
 * 选择排序
 * 每次遍历把找出数组中最小值和第一个交换
 * 下一次遍历从第二个元素开始，找出往后数组中最小值和第二元素交换
 * 以此类推
 * @author wannengqingnian
 */
public class SelectSort {
    public static void main(String [] args) {
        int[] nums = {-1, -5, 5, 8, 2, 3};
        selectSort(nums);

        for (int n : nums){
            System.out.print(n + "\t");
        }
    }

    public static void selectSort(int[] nums){
        int length = nums.length;
        int minIndex;
        for (int i = 0; i < length; i++){
            minIndex = i;
            for (int j = i; j < length; j++){
                if (nums [j] < nums [minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums [i];
            nums [i] = nums[minIndex];
            nums [minIndex] = temp;
        }
    }
}


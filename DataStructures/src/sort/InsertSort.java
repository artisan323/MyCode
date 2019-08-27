package sort;

/**
 * @author wannengqingnian
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {-1, -5, 5, 8, 2, 3};
        TestInsert(nums);

        for (int i : nums){
            System.out.println(i + "\t");
        }
    }

    public static void TestInsert(int[] nums){

        int length = nums.length;

        for (int i = 1; i < length; i++){
            int temp = nums [i];
            int index = i - 1;
            while (index >= 0 && nums[index] > temp){
                nums[index+1] = nums[index];
                index--;
            }
            nums[index+1] = temp;
        }
    }
}

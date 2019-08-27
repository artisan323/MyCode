import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        int[] nums = new int[]{1,0,2,3,4,6,7};
        int[] nums1 = new int [] {0, 1};
        System.out.printf(""+ removeDuplicates(nums1));

    }
    public int singleNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int n = 0;
            for(int j = i; j < nums.length; j++){
                n = nums[i] ^ nums[j];
                int b = 9;
                String s = String.valueOf(b);
            }
        }
        return 0;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        int pre = map.get(s.charAt(0));
        for(int i = 0; i < s.length(); i++){
            int n = map.get(s.charAt(i));
            if(n > pre){
                ans += n;
                ans -= pre*2;
            }else {
                ans += n;
                pre = n;
            }
        }
        return ans;
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n;){
            if (i + 1 == n){
                break;
            }
            if(nums[i] == 0){
                for(int j = i; j < n; j++){
                    if(j+1 == n){
                        continue;
                    }
                    nums[j] = nums[j+1];
                }
                nums[n-1] = 0;

            }else {
                i++;
            }

        }
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            n ^= (nums[i] ^ i);
        }
        return n;
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}

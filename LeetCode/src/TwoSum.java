import java.util.Map;

import	java.util.HashMap;
/**
 * @author wannengqingnian
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
        int n = 0;
        for (int i = 0; i < nums.length; i++){
            n = target - nums [i];
            if (map.containsKey(n)){
                return new int [] {map.get(n), i};
            }
            map.put(nums [i], i);
        }

        throw new RuntimeException("没有");
    }
}

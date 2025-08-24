package Easy;

import java.util.HashMap;
import java.util.Map;

public class removeElement_24082025 {

    // https://leetcode.com/problems/remove-element/description/

    public static void main(String[] args) {
        Map<Integer, int[]> map_nums = Map.of(
                3, new int[]{3, 2, 2, 3},
                2, new int[]{0, 1, 2, 2, 3, 0, 4, 2}
        );
        for(Map.Entry<Integer, int[]> entry : map_nums.entrySet()){
            int k = removeElement(entry.getValue(), entry.getKey());
            System.out.println("k: " + k);
        }
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int j = 0; // inidice do num diferente de val
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val) { // num na posi i diferente de val
                nums[j] = nums[i];
                j ++;
            }
        }
        return j;
    }
}

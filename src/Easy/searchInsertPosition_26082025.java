package Easy;

import java.util.Arrays;
import java.util.Map;

public class searchInsertPosition_26082025 {

    //https://leetcode.com/problems/search-insert-position/

    public static void main(String[] args) {
        Map<Integer, int[]> map = Map.of(
                5, new int[]{1,3,5,6},
                2, new int[]{1,3,5,6},
                7, new int[]{1,3,5,6},
                0, new int[]{1,3,5,6});

        for (Map.Entry<Integer, int[]> entry : map.entrySet()){
            int r = searchInsert(entry.getValue(), entry.getKey());
            System.out.println("nums: " + Arrays.toString(entry.getValue()) + "\n target: " + entry.getKey() + "\n result: " + r);
        }
    }

    public static int searchInsert(int[] nums, int target) {
        // Binary Search
        int l = 0;
        int r = nums.length - 1;

        while (l <= r){
            int m = (l + r) / 2;
            if (nums[m] == target) return m; // Encontrou
            else if (nums[m] > target) { // target na primeira metade
                r = m - 1;
            }
            else{ // target na segunda metade
                l = m + 1;
            }
        }
        // Se não encontrar
        return l;
    }
}

package Easy;

public class removeDuplicatesFromSortedArray_24082025 {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

    public static void main(String[] args) {
        int[][] list_nums = {{1,1,2}, {0,0,1,1,1,2,2,3,3,4}};
        for(int[] nums : list_nums){
            int k = removeDuplicates(nums);
            System.out.println("k: " + k);
        }

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 1; // índice para o próximo número único
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

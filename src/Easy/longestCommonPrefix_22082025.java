package Easy;

import java.util.Arrays;

public class longestCommonPrefix_22082025 {

    // https://leetcode.com/problems/longest-common-prefix/description/

    public static void main(String[] args) {
        String[] teste = {"flower","flow","flight"};
        String result = longestCommonPrefix(teste);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {;
        Arrays.sort(strs);
        for (int idx = 0; idx < Math.min(strs[0].length(), strs[strs.length - 1].length()); idx++) {
            if (strs[0].charAt(idx) != strs[strs.length - 1].charAt(idx)) {
                return strs[0].substring(0, idx);
            }
        }
        return strs[0];
    }
}

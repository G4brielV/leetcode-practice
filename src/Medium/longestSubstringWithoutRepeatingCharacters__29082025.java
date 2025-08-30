package Medium;

import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeatingCharacters__29082025 {

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/

    public static void main(String[] args) {
        String[] list = {"abcabcbb", "bbbbb", "pwwkew", "au"};

        for (String l : list) {

            int result = lengthOfLongestSubstring2(l);
            System.out.println("String: " + l + "\n Result: " + result);
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

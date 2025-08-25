package Easy;

import java.util.Map;

public class findTheIndexOfTheFirstOccurrenceInString_25082025 {

    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

    public static void main(String[] args) {

        Map<String, String> map = Map.of(
                "sad", "sadbutsad",
                "letto", "leetcode",
                "hello", "ll",
                "a", "a",
                "issipi", "mississippi",
                "c", "abc"
        );
        for(Map.Entry<String, String> entry : map.entrySet()){
            int idx = strStr(entry.getValue(), entry.getKey());
            System.out.println("Needle: "+ entry.getKey() + " idx: " + idx);
        }

    }

    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n < m ) return -1; // haystack < needle
        // haystack >= needle
        for(int i = 0; i <= n - m; i ++){
            if (haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i,i+m).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}

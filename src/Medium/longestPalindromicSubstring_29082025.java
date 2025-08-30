package Medium;

public class longestPalindromicSubstring_29082025 {

    // https://leetcode.com/problems/longest-palindromic-substring/description/
    // https://leetcode.com/problems/longest-palindromic-substring/solutions/7136629/longest-palindromic-substring-with-two-p-a72b/

    public static void main(String[] args) {
        String[] list = {"abba", "aba", "abaab", "babad", "cbbd", "abc"};
        for (String str : list){
            String result = longestPalindrome(str);
            System.out.println("String: " + str + "  Result: " + result);
        }
    }


    public static String longestPalindrome(String s) {
        char[] charlist = s.toCharArray();
        // Definindo a primeira letra como o palindromo maior, substring (0,1)
        int start = 0; int end = 1;
        // Indo da primeira letra ate a penultima
        for (int left = 0; left <= charlist.length - 2; left ++){
            // Desde a ultima letra ate quando for possivel formar um palindromo maior que o ja encontrado
            for (int right = charlist.length - 1; right + 1 - left > end - start; right --) {
                int p = left;
                int q = right;
                while (charlist[p] == charlist[q] && p <= q) {
                    p ++;
                    q --;
                }
                // Fechou um palindromo
                if (p > q){
                    start = left;
                    end = right + 1;
                    break;
                }
            }
        }
        return s.substring(start, end);
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // Palíndromo de tamanho ímpar (um único centro)
            int len1 = expandAroundCenter(s, i, i);
            // Palíndromo de tamanho par (centro entre duas letras)
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            // Se encontramos um palíndromo maior, atualizamos índices
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // retorna comprimento do palíndromo
        return right - left - 1;
    }
}

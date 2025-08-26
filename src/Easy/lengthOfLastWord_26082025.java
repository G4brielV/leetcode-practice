package Easy;

public class lengthOfLastWord_26082025 {

    // https://leetcode.com/problems/length-of-last-word/description/

    public static void main(String[] args) {
        String[] list = {"Hello World",
                "   fly me   to   the moon  ",
                "luffy is still joyboy"};
        for (String s : list){
            int r = lengthOfLastWord(s);
            System.out.println("Srt: " + s + "\nLength last word: " + r);
        }
    }

    public static int lengthOfLastWord(String s) {
        s = s.strip();
        for (int i = s.length() - 1; i >= 0; i --){
            if(s.charAt(i) == ' '){
                return s.length()-1 - i;
            }
        }
        return s.length();
    }

    public static int lengthOfLastWord2(String s) {
        String[] split = s.strip().split(" ");
        return split[split.length - 1].length();
    }
}

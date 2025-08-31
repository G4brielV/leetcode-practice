package Medium;

public class reverseInteger_31082025 {

    // https://leetcode.com/problems/reverse-integer/description/

    public static void main(String[] args) {
        int[] list = {123, -123, 120};

        for (int n : list){
            int result = reverse(n);
            System.out.println("Numero: " + n + " Reverse: " + result);
        }
    }

    public static int reverse(int x) {
        // range: [-2^31, 2^31 - 1]
        int neg = 1;
        if (x < 0){
            neg = -1;
            x = -x;
        }
        int result = 0;
        while(x > 0){
            int digit = (x%10);
            // Se res * 10 + digit > limite int então retorna 0
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            x /= 10;
            result = result*10+digit;
        }
        return result * neg;
    }
}

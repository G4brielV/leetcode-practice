package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class zigzagConversion_30082025 {

    //https://leetcode.com/problems/zigzag-conversion/description/

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("AB", 1); //"A", 2, "PAYPALISHIRING", 3

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            String result = convert3(entry.getKey(), entry.getValue());
            System.out.println("Key: " + entry.getKey() + " Result: " + result);
        }
    }

    public static String convert(String s, int numRows) {
        List<Character>[] matriz = new ArrayList[numRows];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new ArrayList<>(); // Inicializa os ArrayList
        }
        int count = 0;
        while (count <= s.length() - 1){
            // Linha
            for (int linha = 0; linha < numRows && count <= s.length() - 1; linha ++){
                matriz[linha].add(s.charAt(count));
                count++;
            }
            // Diagonal
            for(int linha = numRows - 2; linha > 0 && count <= s.length() - 1; linha--){
                matriz[linha].add(s.charAt(count));
                count++;
            }
        }
        String result = "";
        for (List<Character> list : matriz){
            result += list.stream().map(String::valueOf).collect(Collectors.joining());
        }
        return result;
    }

    public static String convert2(String s, int numRows) {
        String[] matriz = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            matriz[i] = "";
        }
        int count = 0;
        while (count <= s.length() - 1){
            // Linha
            for (int linha = 0; linha < numRows && count <= s.length() - 1; linha ++){
                matriz[linha] += s.charAt(count);
                count++;
            }
            // Diagonal
            for(int linha = numRows - 2; linha > 0 && count <= s.length() - 1; linha--){
                matriz[linha] += s.charAt(count);
                count++;
            }
        }
        String result = "";
        for (String strs : matriz){
            result += strs;
        }
        return result;
    }

    public static String convert3(String s, int numRows) {
        String[] matriz = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            matriz[i] = "";
        }
        for (int j = 0; j <= s.length() - 1 && j <= numRows - 1; j++) {
            matriz[j] += s.charAt(j);
        }
        int p = (numRows!= 1 ) ? numRows + (numRows - 2) : 1;

        for (int i = numRows; i <= s.length() - 1; i ++){
            // Primeira linha
            if (i%p == 0){
                matriz[0] += s.charAt(i);
            }
            // Ultima linha
            else if ((i-(numRows-1))%p==0){
                matriz[numRows-1] += s.charAt(i);
            }
            // Diagonal
            else{
                int q = matriz[numRows-1].length() * p;
                if (q > i){
                    matriz[q-i] += s.charAt(i);
                }
                else{
                    matriz[i-q] += s.charAt(i);
                }
            }

        }
        String result = "";
        for (String strs : matriz){
            result += strs;
        }
        return result;
    }

}

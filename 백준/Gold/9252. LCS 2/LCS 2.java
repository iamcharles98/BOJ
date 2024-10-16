import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i < lcs.length; i++) {
            for (int j = 1; j < lcs[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        int row = lcs.length - 1;
        int col = lcs[0].length - 1;
        int maxLength = lcs[row][col];
        List<Character> result = new ArrayList<>();
        while (row > 0 && col > 0) {
            if(lcs[row-1][col] == maxLength) {
                row--;
            } else if(lcs[row][col-1] == maxLength) {
                col--;
            } else {
                result.add(str1.charAt(row-1));
                maxLength--;
                row--;
                col--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=result.size()-1; i>=0; i--) {
            sb.append(result.get(i));
        }

        System.out.print(lcs[str1.length()][str2.length()]+"\n"+sb.toString());



    }
}

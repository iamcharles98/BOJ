
import java.io.*;
import java.util.Stack;

public class Main {

    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            char[] password = br.readLine().toCharArray();

            String answer = decode(password);
            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static String decode(char[] password) {
        Stack<Character> curStack = new Stack<>();
        Stack<Character> postStack = new Stack<>();

        for (int i = 0; i < password.length; i++) {
            if (password[i] == '-') {
                if (!curStack.isEmpty()) {
                    curStack.pop();
                }
                continue;
            }

            if (password[i] == '<') {
                if (!curStack.isEmpty()) {
                    postStack.push(curStack.pop());
                }
                continue;
            }

            if (password[i] == '>') {
                if (!postStack.isEmpty()) {
                    curStack.push(postStack.pop());
                }
                continue;
            }

            curStack.push(password[i]);
        }

        while (!postStack.isEmpty()) {
            curStack.push(postStack.pop());
        }

        char[] result = new char[curStack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = curStack.pop();
        }

        return new String(result);
    }
}

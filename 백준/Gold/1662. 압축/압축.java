
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static String[] inputString;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final String open = "(";
    static final String close = ")";

    static class Info {
        String represent;
        int length;

        public Info(String represent, int length) {
            this.represent = represent;
            this.length = length;
        }

        public int toInt() {
            return Integer.parseInt(represent);
        }
    }

    public static void main(String[] args) throws IOException {
        inputString = br.readLine().split("");

        List<Stack<Info>> multiLevelStack = new ArrayList<>();
        int curLevel = 0;
        multiLevelStack.add(new Stack<>());
        for (String input : inputString) {
            if (input.equals(close)) {
                int curLevelLength = getLengthLevelOf(multiLevelStack.get(curLevel--));
                multiLevelStack.get(curLevel).peek().length =
                        multiLevelStack.get(curLevel).peek().toInt() * curLevelLength;
                continue;
            }

            if (input.equals(open)) {
                multiLevelStack.add(++curLevel, new Stack<>());
                continue;
            }

            multiLevelStack.get(curLevel).push(new Info(input, 1));
        }

        System.out.println(getLengthLevelOf(multiLevelStack.get(0)));


    }

    private static int getLengthLevelOf(Stack<Info> curStack) {
        int curLength = 0;
        while (!curStack.isEmpty()) {
            curLength += curStack.pop().length;
        }
        return curLength;
    }

}

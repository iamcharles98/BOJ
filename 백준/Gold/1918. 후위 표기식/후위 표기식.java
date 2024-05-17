import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> priority = new HashMap<>();
    static Stack<String> operand = new Stack<>();
    static Stack<Operator> operator = new Stack<>();

    static class Operator {
        String op;
        int rate;

        public Operator(String op, int rate) {
            this.op = op;
            this.rate = rate;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        String[] expression = br.readLine().split("");

        int correction = 0;
        for (String str : expression) {
            if (str.equals("(")) {
                correction += 10;
                continue;
            }
            if (str.equals(")")) {
                correction -= 10;
                continue;
            }
            if (priority.containsKey(str)) {
                int priorityValue = priority.get(str) + correction;
                if (operator.isEmpty() || operator.peek().rate < priorityValue) {
                    operator.push(new Operator(str, priorityValue));
                } else {
                    while (!operator.isEmpty() && operator.peek().rate >= priorityValue) {
                        makePostfix();
                    }
                    operator.push(new Operator(str, priorityValue));
                }
            } else {
                operand.push(str);
            }
        }

        while (!operator.isEmpty()) {
            makePostfix();
        }

        System.out.println(operand.pop());

    }

    private static void makePostfix() {
        StringBuilder sb = new StringBuilder();
        String op1 = operand.pop();
        String op2 = operand.pop();
        sb.append(op2).append(op1).append(operator.pop().op);
        operand.push(sb.toString());
    }

    private static void init() {
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 5);
        priority.put("/", 5);
    }


}

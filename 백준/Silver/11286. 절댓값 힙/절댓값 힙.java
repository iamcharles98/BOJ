

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static Integer N;
    static final Integer OPERATOR = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Node> list = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.abs == o2.abs) {
                    return o1.sign - o2.sign;
                }
                return o1.abs - o2.abs;
            }
        });

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            if (input == OPERATOR) {
                Node node = list.poll();
                if (node != null) {
                    System.out.println(node.abs * node.sign);
                } else {
                    System.out.println(0);
                }
                continue;
            }
            list.add(new Node(input));
        }

    }


    static class Node {
        int abs;
        int sign;

        public Node(int abs) {
            this.abs = Math.abs(abs);
            this.sign = (abs < 0) ? -1 : 1;
        }
    }
}

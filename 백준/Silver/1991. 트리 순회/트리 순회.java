

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, List<String>> tree = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String node = stringTokenizer.nextToken();
            String left = stringTokenizer.nextToken();
            String right = stringTokenizer.nextToken();
            tree.put(node, List.of(left, right));
        }

        preOrder(tree, "A");
        System.out.println("");
        inOrder(tree, "A");
        System.out.println("");
        postOrder(tree, "A");
    }

    private static void postOrder(HashMap<String, List<String>> tree, String node) {
        //왼쪽 -> 오른쪽 -> 노드
        if (node.equals(".")) {
            return;
        }
        List<String> childNodes = tree.get(node);
        postOrder(tree,childNodes.get(0));
        postOrder(tree,childNodes.get(1));
        System.out.print(node);
    }

    private static void inOrder(HashMap<String, List<String>> tree, String node) {
        //왼쪽 -> 노드 -> 오른쪽
        if (node.equals(".")) {
            return;
        }
        List<String> childNodes = tree.get(node);
        inOrder(tree,childNodes.get(0));
        System.out.print(node);
        inOrder(tree,childNodes.get(1));
    }

    private static void preOrder(HashMap<String, List<String>> tree, String node) {
        //루트 -> 왼쪽 -> 오른쪽
        if (node.equals(".")) {
            return;
        }
        System.out.print(node);
        List<String> childNodes = tree.get(node);
        preOrder(tree,childNodes.get(0));
        preOrder(tree,childNodes.get(1));


    }
}

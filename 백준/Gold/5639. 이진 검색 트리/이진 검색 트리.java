import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
        }

        void insert(int key) {
            if (key < this.key) {
                if (left == null) {
                    this.left = new Node(key);
                } else {
                    this.left.insert(key);
                }
            } else {
                if (right == null) {
                    this.right = new Node(key);
                } else {
                    this.right.insert(key);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {

            String s = br.readLine();
            if (s == null) {
                break;
            }

            root.insert(Integer.parseInt(s));
        }

        postTravel(root);

    }

    private static void postTravel(Node root) {
        if (root == null) {
            return;
        }

        postTravel(root.left);
        postTravel(root.right);
        System.out.println(root.key);

    }
}

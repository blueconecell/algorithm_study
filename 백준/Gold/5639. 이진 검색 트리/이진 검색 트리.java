import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Node root = new Node(Integer.parseInt(br.readLine()));

        while ((input = br.readLine()) != null && !input.equals("")) {
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);

    }

    private static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }


    private static class Node {
        int value;
        Node left, right, parent;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int n) {
            if (this.value > n) {
                if (this.left == null) {
                    this.left = new Node(n);
                }else{
                    this.left.insert(n);
                }
            }else{
                if(this.right == null) {
                    this.right = new Node(n);
                }else{
                    this.right.insert(n);
                }
            }
        }

        @Override
        public String toString() {
            return "{" +
                    value +
                    ", " + left +
                    " : " + right +
                    " p =" + parent +
                    '}';
        }
    }
}
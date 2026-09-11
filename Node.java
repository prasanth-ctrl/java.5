package sample;

public class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

    static Node first = null;
    static Node second = null;
    static Node previous = null;

    static void recoveryBTS(Node root) {

        if (root == null) {
            return;
        }

        recoveryBTS(root.left);

        if (previous != null && previous.data > root.data) {

            if (first == null) {
                first = previous;
            }

            second = root;
        }

        previous = root;

        recoveryBTS(root.right);
    }

    static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(40);

        root.left = new Node(60);
        root.right = new Node(20);

        root.left.left = new Node(10);
        root.left.right = new Node(30);

        root.right.left = new Node(50);
        root.right.right = new Node(70);

        System.out.println("Before recovery:");
        inorder(root);
        System.out.println();

        recoveryBTS(root);

        int temp = first.data;
        first.data = second.data;
        second.data = temp;

        System.out.println("After recovery:");
        inorder(root);
        System.out.println();
    }
}
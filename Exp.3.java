public class BSTTraversal {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Insert into BST
    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {

        Node root = null;

        // Create BST
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            root = insert(root, value);
        }

        // Preorder traversal
        System.out.print("Preorder: ");
        preorder(root);

        // Postorder traversal
        System.out.print("\nPostorder: ");
        postorder(root);
    }
}
package Week10;

import java.util.*;

class Insertion {

    public static void preOrder( Node root ) {
        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node insert(Node root,int data) {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(data);
        }
        // if the given key is more than the root node, recur for the right subtree
        if (root.data < data)
            root.right = insert(root.right, data);
        else
            root.left = insert(root.left, data);
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
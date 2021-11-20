package Week10;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    public static int height(Node root) {

        int leftHeight = 0;
        int rightHeight = 0;

        if (root.left != null) {
            leftHeight = 1 + height(root.left);
        }

        if (root.right != null) {
            rightHeight = 1 + height(root.right);
        }

        if (leftHeight >= rightHeight)
        return leftHeight;
        else return rightHeight;

//        if(root == null){
//            return -1;
//        }
//        int count = -1;
//        Queue<Node> p = new LinkedList<Node>();
//        p.add(root);
//        while(!p.isEmpty()){
//            int n = p.size();
//            for(int i = 0; i < n; i++){
//                Node temp = p.remove();
//                if(temp.left != null){
//                    p.add(temp.left);
//                }
//                if(temp.right != null){
//                    p.add(temp.right);
//                }
//            }
//            count++;
//        }
//        return count;


//        if(root==null) return -1;
//        return 1+Math.max(height(root.left),height(root.right));
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
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
        int height = height(root);
        System.out.println(height);
    }
}
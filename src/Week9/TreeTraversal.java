package Week9;

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

    public static void inOrder(Node root) {     //O(N)
        if(root != null) {
            inOrder(root.left);         // Traverse the left subtree
            System.out.print(root.data + " ");  // Display the data part of the root (or current node)
            inOrder(root.right);         // Traverse the right subtree
        }

//        Deque<Node> stack = new ArrayDeque<Node>();
//        while(!stack.isEmpty() || root!=null){
//            if(root!=null){
//                stack.push(root);
//                root = root.left;
//            }else{
//                root = stack.pop();
//                System.out.print(root.data+" ");
//                root = root.right;
//            }
//        }


//        Node pre;
//        if(root == null)
//            return;
//        Node curr = root;
//        while(curr != null){
//            if(curr.left == null){
//                System.out.print(curr.data+" ");
//                curr = curr.right;
//            }else{
//                pre = curr.left;
//                while(pre.right !=null && pre.right != curr)
//                    pre = pre.right;
//                if(pre.right == null){
//                    pre.right = curr;
//                    curr = curr.left;
//                }else{
//                    pre.right=null;
//                    System.out.print(curr.data+" ");
//                    curr=curr.right;
//                }
//            }
//        }
    }

    public static void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);                   //O(1)
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node != null) {
                System.out.print(node.data + " ");
                stack.push(node.right);
                stack.push(node.left);
            }
        }

//        if(root==null){
//            return ;
//        }
//        System.out.print(root.data+" ");
//        preOrder(root.left);
//        preOrder(root.right);
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);   //O(1)

        while(!queue.isEmpty()) {
            Node tempNode = queue.poll();   //O(1)
            System.out.print(tempNode.data + " ");
            if(tempNode.left != null)
                queue.add(tempNode.left);
            if(tempNode.right != null)
                queue.add(tempNode.right);
        }
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
        inOrder(root);
        preOrder(root);
        levelOrder(root);
    }
}
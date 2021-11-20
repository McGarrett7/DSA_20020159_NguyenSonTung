package Week10;

import java.util.*;

class LowestBinaryTree {

    public static Node lca(Node root, int v1, int v2) {

        //Nho hon ca 2 node
        if(root.data < v1 && root.data < v2){
            return lca(root.right, v1, v2);
        }
        //Lon hon ca 2 node
        if(root.data > v1 && root.data > v2){
            return lca(root.left, v1, v2);
        }
        return root;


//        if(root == null) return root;
//        if(root.data == v1 || root.data == v2) return root;
//        Node rootLeft = lca(root.left,v1,v2);
//        Node rootRight = lca(root.right,v1,v2);
//        if(rootLeft==null && rootRight==null) return null;
//        if(rootRight==null) return rootLeft;
//        if(rootLeft==null) return rootRight;
//        return root;


//        Node temp=root;
//        while(true){
//
//            if((v1>=temp.data)&&(v2<=temp.data)){
//                return temp;
//            }
//
//            if((v1<=temp.data)&&(v2>=temp.data)){
//                return temp;
//            }
//            if((v1<temp.data)&&(v2<temp.data)){
//                temp=temp.left;
//            }
//
//            if((v1>temp.data)&&(v2>temp.data)){
//                temp=temp.right;
//            }
//        }

//        if(root == null){
//            return root;
//        }
//
//        if(root.data == v1 || root.data == v2){
//            return root;
//        }
//
//        Node left = lca(root.left, v1, v2);
//        Node right = lca(root.right, v1, v2);
//
//        if(left != null && right != null){
//            return root;
//        }
//        else
//            return (left != null) ? left: right;
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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}
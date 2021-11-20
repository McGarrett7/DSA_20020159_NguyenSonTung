package Week10;

public class CheckBST {
    boolean checkBST(Node root) {
        return isBSTNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBSTNode(Node root, int min, int max) {
        boolean isBstNode = false;
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return (isBSTNode(root.left, min, root.data - 1) && isBSTNode(root.right, root.data + 1, max));
    }
}

//    boolean check(Node root, int min, int max) {
//        if (root != null) {
//            if (root.data >= max || root.data <= min) {
//                return false;
//            }
//            else {
//                return check(root.left, min, root.data) & check(root.right, root.data, max);
//            }
//        }
//        else {
//            return true;
//        }
//    }
//
//    boolean checkBST(Node root) {
//        return check(root, 0, Integer.MAX_VALUE);
//    }

//    boolean left(Node root, int pdata) {
//        if (root == null) return true;
//        if (root.data >= pdata) return false;
//        return left(root.left, root.data) && left(root.left, pdata) &&
//                left(root.right, pdata) && right(root.right, root.data);
//    }
//
//    boolean right(Node root, int pdata) {
//        if (root == null) return true;
//        if (root.data <= pdata) return false;
//        return right(root.right, root.data) && right(root.right, pdata) &&
//                right(root.left, pdata) && left(root.left, root.data);
//    }
//
//    boolean checkBST(Node root) {
//        return left(root.left, root.data) && right(root.right, root.data);
//    }

//    boolean checkBST(Node root) {
//        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    boolean checkBSTHelper(Node root, int low, int high) {
//        if(root == null) return true;
//        return root.data > low && root.data < high && checkBSTHelper(root.left, low, root.data)
//                && checkBSTHelper(root.right, root.data, high);
//    }

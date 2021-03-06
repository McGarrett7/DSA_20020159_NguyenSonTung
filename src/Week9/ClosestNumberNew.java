package Week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumberNew {

    public ArrayList<String> mergeSort(ArrayList<String> whole) {
        ArrayList<String> left = new ArrayList<String>();
        ArrayList<String> right = new ArrayList<String>();
        int center;

        if (whole.size() == 1) {
            return whole;
        } else {
            center = whole.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                left.add(whole.get(i));
            }

            //copy the right half of whole into the new arraylist.
            for (int i=center; i<whole.size(); i++) {
                right.add(whole.get(i));
            }

            // Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);

            // Merge the results back together.
            merge(left, right, whole);
        }
        return whole;
    }

    private void merge(ArrayList<String> left, ArrayList<String> right, ArrayList<String> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;

        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }

        ArrayList<String> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }

        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }
//    void merge(int arr[], int l, int m, int r) {
//
//        // T??m k??ch th?????c c???a 2 m???ng con ????? merged
//        int n1 = m - l + 1;
//        int n2 = r - m;
//
//        // T???o m???ng t???m
//        int L[] = new int[n1];
//        int R[] = new int[n2];
//
//        // Copy d??? li???u v??o m???ng t???m
//        for (int i = 0; i < n1; ++i)
//            L[i] = arr[l + i];
//        for (int j = 0; j < n2; ++j)
//            R[j] = arr[m + 1 + j];
//
//        // Merge c??c m???ng t???m l???i
//
//        // Ch??? m???c ban ?????u c???a 2 m???ng con
//        int i = 0, j = 0;
//
//        // Ch??? m???c ban ?????u c???a m???ng ph??? ???????c h???p nh???t
//        int k = l;
//        while (i < n1 && j < n2) {
//            if (L[i] <= R[j]) {
//                arr[k] = L[i];
//                i++;
//            } else {
//                arr[k] = R[j];
//                j++;
//            }
//            k++;
//        }
//
//        // Sao ch??p c??c ph???n t??? c??n l???i c???a L[] n???u c??
//        while (i < n1) {
//            arr[k] = L[i];
//            i++;
//            k++;
//        }
//
//        // Sao ch??p c??c ph???n t??? c??n l???i c???a R[] n???u c??
//        while (j < n2) {
//            arr[k] = R[j];
//            j++;
//            k++;
//        }
//    }
//
//    void sort(int arr[], int l, int r) {
//        if (l < r) {
//
//            // T??m ??i???m ch??nh gi???a
//            int m = (l + r) / 2;
//
//            // H??m ????? quy ti???p t???c chia ????i
//            sort(arr, l, m);
//            sort(arr, m + 1, r);
//
//            merge(arr, l, m, r);
//        }
//    }
    }
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
//        // Tìm kích thước của 2 mảng con để merged
//        int n1 = m - l + 1;
//        int n2 = r - m;
//
//        // Tạo mảng tạm
//        int L[] = new int[n1];
//        int R[] = new int[n2];
//
//        // Copy dữ liệu vào mảng tạm
//        for (int i = 0; i < n1; ++i)
//            L[i] = arr[l + i];
//        for (int j = 0; j < n2; ++j)
//            R[j] = arr[m + 1 + j];
//
//        // Merge các mảng tạm lại
//
//        // Chỉ mục ban đầu của 2 mảng con
//        int i = 0, j = 0;
//
//        // Chỉ mục ban đầu của mảng phụ được hợp nhất
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
//        // Sao chép các phần tử còn lại của L[] nếu có
//        while (i < n1) {
//            arr[k] = L[i];
//            i++;
//            k++;
//        }
//
//        // Sao chép các phần tử còn lại của R[] nếu có
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
//            // Tìm điểm chính giữa
//            int m = (l + r) / 2;
//
//            // Hàm đệ quy tiếp tục chia đôi
//            sort(arr, l, m);
//            sort(arr, m + 1, r);
//
//            merge(arr, l, m, r);
//        }
//    }
    }
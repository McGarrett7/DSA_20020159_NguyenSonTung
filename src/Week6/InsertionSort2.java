package Week6;

public class InsertionSort2 {
    static void insertionSort2(int n, int[] arr) {
        for (int i = 2; i <= n; i++) {
            insertionSort1(i, arr);
        }
    }

    static void insertionSort1(int n, int[] arr) {
        int last = arr[n - 1];
        int i = n - 2;
        for (; (i >= 0) && (arr[i] > last); i--) {
            arr[i + 1] = arr[i];
           // printArray(arr);
        }
        arr[i + 1] = last;
        printArray(arr);
    }

//    public static void insertionSort2(int n, int[] arr) {
//        for (int i = 0; i < n - 1; i++) {
//            int j = i + 1;
//            while (j > 0) {
//                if(arr[j] < arr[j - 1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                    j--;
//                } else {
//                    break;
//                }
//            }
//            printArray(arr);
//        }
//    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 3, 5, 6, 2};
        insertionSort2(6, arr);
    }
}
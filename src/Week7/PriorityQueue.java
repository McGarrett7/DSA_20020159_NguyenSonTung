package Week7;

public class PriorityQueue {

    Integer[] arr;
    int size;

    PriorityQueue() {
        arr = new Integer[2];
        size = 0;
    }

    void insert(int n) {
        if (arr.length == size) {
            Integer[] newArray = new Integer[arr.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        arr[size] = Integer.valueOf(n);
        int j = size - 1;
        while (j >= 0 && arr[j + 1] > arr[j]) {
            Integer temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            j--;
        }
        size++;
    }

    int deleteMin() {
        int result = arr[size - 1].intValue();
        arr[size - 1] = null;
        size--;
        if (size == arr.length / 4) {
            Integer[] newArr = new Integer[arr.length / 2];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        return result;
    }
}
package Week1;

class sapXepTangDan {
    public sapXepTangDan(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
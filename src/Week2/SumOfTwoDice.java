package Week2;

public class SumOfTwoDice {
    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            int random_int = (int) (Math.random() * 6 + 1);
            System.out.println(random_int);
        }
    }
}

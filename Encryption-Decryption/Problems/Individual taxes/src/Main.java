import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        double[] numbers = new double[len];
        double[] taxes = new double[len];
        double first;
        double second;
        double temp = 0;
        int result = len == 1 ? 1 : 2;

        for (int i = 0; i < len; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < len; i++) {
            taxes[i] = scanner.nextInt();
        }
        for (int i = 0; i < len - 1; i++) {
            first = numbers[i] * (taxes[i] / 100);
            second = numbers[i + 1] * (taxes[i + 1] / 100);
            if (first > second && temp <= first) {
                temp = first;
                result = i + 1;
            }
        }
        System.out.println(result);
    }
}
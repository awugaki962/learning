import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] numbers = new int[len];
        int marker = 1;
        int result = 1;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1] && marker <= result) {
                marker++;
                result = marker;
            } else {
                marker = 1;
            }
        }
        System.out.println(result);
    }
}
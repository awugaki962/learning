import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] numbers = new int[len];
        int result = 0;
        int marker = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] + 1 == numbers[i + 1] &&
                    numbers[i] + 2 == numbers[i + 2] && marker >= result) {
                marker++;
                result = marker;
            } else {
                marker = 0;
            }
        }
        System.out.println(result);
    }
}
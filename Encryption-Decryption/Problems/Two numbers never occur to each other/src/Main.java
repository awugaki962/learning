import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        boolean result = true;

        for (int j = 0; j < len - 1; j++) {
            if ((array[j] == first && array[j + 1] == second) ||
                    (array[j] == second && array[j + 1] == first)) {
                result = false;
            }
        }
        System.out.println(result);
    }
}
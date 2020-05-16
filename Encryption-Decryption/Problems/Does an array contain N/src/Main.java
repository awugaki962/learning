import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int lookingFor = scanner.nextInt();
        boolean result = false;

        for (int i = 0; i < len; i++) {
            if (arr[i] == lookingFor) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }
}
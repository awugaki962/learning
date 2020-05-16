// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        boolean result = true;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] + 1 != chars[i + 1]) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
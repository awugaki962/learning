// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = new char[6];
        chars = str.toCharArray();

        int firstThree = 0;
        int secondThree = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i < 3) {
                firstThree += Character.getNumericValue(chars[i]);
            } else {
                secondThree += Character.getNumericValue(chars[i]);
            }
        }
        if (firstThree == secondThree) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}
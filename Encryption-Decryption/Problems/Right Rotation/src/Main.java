import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int shift = scanner.nextInt();
        String[] strnum = str.split(" ");
        int len = strnum.length;
        int[] numbers = new int[len];
        int[] resultArray = new int[len];

        for (int i = 0; i < len; i++) {
            numbers[i] = Integer.parseInt(strnum[i]);
        }
        for (int i = 0; i < len; i++) {
            resultArray[(i + shift) % len] = numbers[i];
        }
        for (int i = 0; i < len; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }
}
// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int piece;
        int countLarger = 0;
        int countSmaller = 0;
        int countPerfect = 0;


        for (int i = 0; i < total; i++) {
            piece = scanner.nextInt();
            if (piece == 1) {
                countLarger++;
            } else if (piece == -1) {
                countSmaller++;
            } else if (piece == 0) {
                countPerfect++;
            }
        }
        System.out.println(countPerfect + " " + countLarger + " " + countSmaller);
    }
}
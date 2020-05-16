import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String[] word = scanner.nextLine().toLowerCase().split("");
        String vowels = "aeiouy";
        int count = 0;
        int vow = 0;
        int cons = 0;
        for (String ch : word) {
            if (vowels.contains(ch)) {
                vow++;
                if (vow ==3 ) {
                    count++;
                    vow = 1;
                }
                cons = 0;
            } else {
                cons++;
                if (cons == 3) {
                    count++;
                    cons = 1;
                }
                vow = 0;
            }
        }
        System.out.println(count);
    }
}
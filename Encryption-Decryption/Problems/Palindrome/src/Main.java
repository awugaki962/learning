import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String newStr = "";
        String result = "no";

        for (int i = 0; i < str.length(); i++) {
            newStr = str.charAt(i) + newStr;
        }
        if (str.equals(newStr)) {
            result = "yes";
        }
        System.out.println(result);
    }
}
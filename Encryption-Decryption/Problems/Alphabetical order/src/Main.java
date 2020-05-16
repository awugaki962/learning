import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        boolean result = true;

        if (str[0].equals("") || str[1].equals("")) {
            result = false;
        }

        for (int i = 0; i <  str.length - 1; i++) {
            if (str[i].compareTo(str[i + 1]) >= 0 && !str[i].equals(str[i + 1])) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
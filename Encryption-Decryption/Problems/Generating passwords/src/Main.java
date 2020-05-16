import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int upper = scanner.nextInt();
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int upperLen = upperChars.length();
        boolean upperFlag = true;
        int lower = scanner.nextInt();
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        int lowerLen = lowerChars.length();
        boolean lowerFlag = true;
        int digits = scanner.nextInt();
        boolean digitFlag = true;
        int length = scanner.nextInt();
        int random = 0;
        String currentChar = "";
        int counter = 0;
        int marker = 0;
        String result = "";

        while (marker != length) {
            while (counter != upper && upperFlag) {
                random = (int) (Math.random() * upperLen);
                currentChar = upperChars.substring(random, random + 1);
                if (!result.equals("")) {
                    if (currentChar.equals(result.substring(result.length() - 1, result.length()))) {
                        currentChar = upperChars.substring((random + 1) % upperLen, (random + 2) % upperLen);
                    }
                }
                result = result + currentChar;
                counter++;
            }
            marker += counter;
            upperFlag = false;
            counter = 0;

            while (counter != lower && lowerFlag) {
                random = (int) (Math.random() * lowerLen);
                currentChar = lowerChars.substring(random, random + 1);
                if (!result.equals("")) {
                    if (currentChar.equals(result.substring(result.length() - 1, result.length()))) {
                        currentChar = lowerChars.substring((random + 1) % lowerLen, (random + 2) % lowerLen);
                    }
                }
                result = result + currentChar;
                counter++;
            }
            marker += counter;
            lowerFlag = false;
            counter = 0;

            while (counter != digits && digitFlag) {
                currentChar = "" + (counter % 10);
                result = result + currentChar;
                counter++;
            }
            marker += counter;
            digitFlag = false;
            counter = 0;
            if (marker == length) {
                break;
            } else {
                if (marker % upperLen == 25) {
                    result = result + upperChars.substring(3, 4);
                } else {
                    result = result + upperChars.substring(marker % upperLen, (marker + 1) % upperLen);
                }
                marker++;
            }
        }
        System.out.println(result);
    }
}
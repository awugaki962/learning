// Posted from EduTools plugin
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int charNum = reader.read();
            char theChar;
            String str = "";

            while (charNum != -1) {
                theChar = (char) charNum;
                str = theChar + str;
                charNum = reader.read();
            }
            System.out.print(str);
        }
    }
}
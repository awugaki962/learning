// Posted from EduTools plugin
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int counter = 0;
            int previous = -1;
            int data = reader.read();

            while (data == 32) {
                data = reader.read();
            }

            if (data != 32 && data != -1) {
                counter++;

                while (data != -1) {
                    if (previous != 32 && data == 32) {
                        counter++;
                    }
                    previous = data;
                    data = reader.read();
                }
            }
            System.out.println(counter);
        }
    }
}
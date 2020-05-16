// Posted from EduTools plugin
import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int data = inputStream.read();

        while (data != -1) {
            System.out.print(data);
            data = inputStream.read();
        }
        inputStream.close();
    }
}
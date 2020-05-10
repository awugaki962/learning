package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Project {
    private String method;

    public Project(String method) {
        this.method = method;
    }

    public void run(String mode, String data, int key) {
        switch (method) {
            case "shift":
                if (mode.equals("enc")) {
                //Ha nem lett megadva a bemeneti fájl, vagy az adat meg lett adva manuálisan
                    if (Main.inData.equals("") || !data.equals("")) {
                        Shift.encode(data, key);
                    } else {
                        String fromFile = fileReading(Main.inData);
                        Shift.encode(fromFile, key);
                    }
                } else {
                    if (Main.inData.equals("") || !data.equals("")) {
                        Shift.decode(data, key);
                    } else {
                        String fromFile = fileReading(Main.inData);
                        Shift.decode(fromFile, key);
                    }
                }
                break;
            case "unicode":
                if (mode.equals("enc")) {
                    if (Main.inData.equals("") || !data.equals("")) {
                        Unicode.encode(data, key);
                    } else {
                        String fromFile = fileReading(Main.inData);
                        Unicode.encode(fromFile, key);
                    }
                } else {
                    if (Main.inData.equals("") || !data.equals("")) {
                        Unicode.decode(data, key);
                    } else {
                        String fromFile = fileReading(Main.inData);
                        Unicode.decode(fromFile, key);
                    }
                }
                break;
        }
    }

    public static String fileReading(String inData) {
        File file = new File(inData);
        try (Scanner fileRead = new Scanner(file)) {
            Main.data = fileRead.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return Main.data;
    }

    public static void fileWriting(String result) {
        File file = new File(Main.outData);
        try (FileWriter write = new FileWriter(file)) {
            write.write(result);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}

class Shift {
    static String abc = "abcdefghijklmnopqrstuvwxyz";
    static char currentChar;
    static String result = "";

    public static void encode(String str, int mod) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < abc.length(); j++) {
                currentChar = str.charAt(i);
                //Ha az aktuális karakter nagybetű
                if (currentChar > 64 && currentChar < 91) {
                    abc = abc.toUpperCase();
                } else {
                    abc = abc.toLowerCase();
                }
                Ha az aktuális karakter nincs a megadott abc-ben
                if (currentChar < 65) {
                    result = result + currentChar;
                    break;
                }
                if (str.substring(i, i + 1).equals(abc.substring(j, j + 1))) {
                    int fract = (j + mod) % abc.length();
                    result = result + abc.substring(fract, fract + 1);
                    break;
                }
            }
        }
        output(result);
    }

    public static void decode(String str, int mod) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < abc.length(); j++) {
                currentChar = str.charAt(i);
                if (currentChar > 64 && currentChar < 91) {
                    abc = abc.toUpperCase();
                } else {
                    abc = abc.toLowerCase();
                }
                if (currentChar < 65) {
                    result = result + currentChar;
                    break;
                }
                if (str.substring(i, i + 1).equals(abc.substring(j, j + 1))) {
                //Ha az eltolás miatt nem fér bele az abc hosszúságába (lásd -4 % 26 == -4)
                    int fract = (j - mod) % abc.length() < 0 ? 26 + (j - mod) % abc.length() : (j - mod) % abc.length();
                    result = result + abc.substring(fract, fract + 1);
                    break;
                }
            }
        }
        output(result);
    }

    public static void output(String result) {
        if (Main.outData.equals("")) {
            System.out.println(result);
        } else {
            Project.fileWriting(result);
        }
    }
}

class Unicode{
    static String result = "";

    public static void encode(String str, int mod) {
        for (char c : str.toCharArray()) {
            result += (char) (c + mod);
        }
        output(result);
    }

    public static void decode(String str, int mod) {
        for (char c : str.toCharArray()) {
            result += (char) (c - mod);
        }
        output(result);
    }

    public static void output(String result) {
        if (Main.outData.equals("")) {
            System.out.println(result);
        } else {
            Project.fileWriting(result);
        }
    }
}

public class Main {

    static String mode = "enc";
    static int key = 0;
    static String data = "";
    static String inData = "";
    static String outData = "";
    static String algorithm = "shift";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    inData = ".\\" + args[i + 1];
                    break;
                case "-out":
                    outData = ".\\" + args[i + 1];
                    break;
                case "-alg":
                    algorithm = args[i + 1];
                    break;
            }
        }

        Project project = new Project(algorithm);
        project.run(mode, data, key);
    }
}

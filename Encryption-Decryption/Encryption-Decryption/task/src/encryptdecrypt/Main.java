package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Project {
    private final String method;

    public Project(String method) {
        this.method = method;
    }

    public void run(String mode, String data, int key) {
        
        data = standardizeData(data);

        if ("shift".equals(method)) {
            if ("enc".equals(mode)) {
                new Shift().encode(data, key);
            } else {
                new Shift().decode(data, key);
            }
        } else if ("unicode".equals(method)) {
            if ("enc".equals(mode)) {
                new Unicode().encode(data, key);
            } else {
                new Unicode().decode(data, key);
            }
        } else {
            System.out.println("Error occured in the algorithm choosing part!");
        }
    }

    public String fileReading(String inData) {
        File file = new File(inData);
        try (Scanner fileRead = new Scanner(file)) {
            Main.data = fileRead.nextLine();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return Main.data;
    }

    public String standardizeData(String data) {
        if (!"".equals(Main.inData) || "".equals(data)) {
            return fileReading(Main.inData);
        }
        return data;
    }
}

abstract class UtilityClass {

    public abstract void encode(String str, int mod);

    public abstract void decode(String str, int mod);

    public void fileWriting(String result) {
        File file = new File(Main.outData);
        try (FileWriter write = new FileWriter(file)) {
            write.write(result);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void output(String result) {
        if ("".equals(Main.outData)) {
            System.out.println(result);
        } else {
            fileWriting(result);
        }
    }
}

class Shift extends UtilityClass {
    String abc = "abcdefghijklmnopqrstuvwxyz";
    char currentChar;
    String result = "";

    public void encode(String str, int mod) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < abc.length(); j++) {
                currentChar = str.charAt(i);
                if (currentChar >= 'A' && currentChar <= 'Z') {
                    abc = abc.toUpperCase();
                } else {
                    abc = abc.toLowerCase();
                }
                if (currentChar < 'A') {
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

    public void decode(String str, int mod) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < abc.length(); j++) {
                currentChar = str.charAt(i);
                if (currentChar >= 'A' && currentChar <= 'Z') {
                    abc = abc.toUpperCase();
                } else {
                    abc = abc.toLowerCase();
                }
                if (currentChar < 'A') {
                    result = result + currentChar;
                    break;
                }
                if (str.substring(i, i + 1).equals(abc.substring(j, j + 1))) {
                    int fract = (j - mod) % abc.length() < 0 ? 26 + (j - mod) % abc.length() : (j - mod) % abc.length();
                    result = result + abc.substring(fract, fract + 1);
                    break;
                }
            }
        }
        output(result);
    }
}

class Unicode extends UtilityClass {
    private String result = "";

    public void encode(String str, int mod) {
        for (char c : str.toCharArray()) {
            result += (char) (c + mod);
        }
        output(result);
    }

    public void decode(String str, int mod) {
        for (char c : str.toCharArray()) {
            result += (char) (c - mod);
        }
        output(result);
    }
}

public class Main {


    private static final String MODE = "-mode";
    protected static String mode = "enc";
    private static final String KEY = "-key";
    protected static int key = 0;
    private static final String DATA = "-data";
    protected static String data = "";
    private static final String INDATA = "-in";
    protected static String inData = "";
    private static final String OUTDATA = "-out";
    protected static String outData = "";
    private static final String ALG = "-alg";
    protected static String algorithm = "shift";

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i += 2) {
            String argumentum = args[i + 1].toLowerCase();
            switch (args[i]) {
                case MODE:
                    mode = argumentum;
                    break;
                case KEY:
                    key = Integer.parseInt(argumentum);
                    break;
                case DATA:
                    data = argumentum;
                    break;
                case INDATA:
                    inData = "." + File.separator + argumentum;
                    break;
                case OUTDATA:
                    outData = "." + File.separator + argumentum;
                    break;
                case ALG:
                    algorithm = argumentum;
                    break;
                default:
                    System.out.println("Incompatible parameters!");
            }
        }

        Project project = new Project(algorithm);
        project.run(mode, data, key);
    }
}
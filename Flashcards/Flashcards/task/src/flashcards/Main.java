package flashcards;

import java.util.Scanner;

class Cards {
    private String term;
    private String definition;

    public Cards(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of cards:\r");
        int repetition = scanner.nextInt();
        scanner.nextLine();
        String answer;
        String[] term = new String[repetition];
        String[] definition = new String[repetition];

        for (int i = 0; i < repetition; i++) {
            System.out.printf("The card #%d:\r\n", i);
            term[i] = scanner.nextLine();
            System.out.printf("The definition of the card #%d:\r\n", i);
            definition[i] = scanner.nextLine();
        }

        for (int i = 0; i < repetition; i++) {
            System.out.printf("Print the definition of \"%s\":\r\n", term[i]);
            answer = scanner.nextLine();
            if (answer.equals(definition[i])) {
                System.out.println("Correct answer.");
            } else {
                System.out.printf("Wrong answer. The correct one is \"%s\".\r\n", definition[i]);
            }
        }
    }
}
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

    private static final String SAVE_FILE_NAME = "save.txt";

    private ArrayList<FlashCard> flashCards;

    public Quiz(FlashCardReader reader) {
        this.flashCards = reader.getFlashCards();

        this.play();
    }

    public void play() {
        StringBuilder gameHistory = new StringBuilder();
        int correctAnswers = 0;

        // Runs a command line question-answer game and saves the outcome in gameHistory
        for (FlashCard flashCard : this.flashCards) {
            System.out.println(flashCard.getQuestion());
            gameHistory.append(flashCard.getQuestion());

            // Take the user's answer
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            gameHistory.append(", " + answer);

            // Check if answer is right and show appropriate message
            if (answer.trim().equals(flashCard.getAnswer())) {
                System.out.println("Correct!");
                gameHistory.append(", correct");
                correctAnswers += 1;
            } else {
                System.out.println("Wrong! The answer: " + flashCard.getAnswer());
                gameHistory.append(", wrong");
            }

            System.out.println();
            gameHistory.append("\n");
        }

        // Add the player's score to the history
        gameHistory.append("Questions asked - " + this.flashCards.size()
                + ". Score - " + correctAnswers * 100 / this.flashCards.size() + "%.");

        // Ask the user if the should be saved
        System.out.println("Would you like to save the game history?(y/n)");
        Scanner scanner = new Scanner(System.in);

        if (scanner.next().equals("y")) {
            this.save(gameHistory.toString());
            System.out.println("History saved!");
        }
    }

    public void save(String content) {
        try {
            Files.write(Paths.get(SAVE_FILE_NAME), content.getBytes());
        } catch (IOException e) {
            System.err.println("Failed to save game history.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz(new FlashCardReader());
    }
}

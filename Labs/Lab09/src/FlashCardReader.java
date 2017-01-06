import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FlashCardReader {

    private static final String DEFAULT_FILE_NAME = "Questions.txt";

    private BufferedReader reader;

    public FlashCardReader() {
        try {
            this.reader = new BufferedReader(new FileReader(DEFAULT_FILE_NAME));
        } catch (FileNotFoundException e) {
            System.err.println("The file " + DEFAULT_FILE_NAME + " could not be found. Check file directory.");
            e.printStackTrace();
        }
    }

    private String getLine() throws IOException {
        return this.reader.readLine();
    }

    private boolean isFileReady() throws IOException {
        return this.reader.ready();
    }

    public ArrayList<FlashCard> getFlashCards() {
        ArrayList<FlashCard> flashCards = new ArrayList<>();

        try {
            // If the file is ready, read until the end and fill flashCards
            if (this.isFileReady()) {
                String line = this.getLine();

                while (line != null) {
                    // Split question and answer
                    String[] args = line.split("-");
                    String question = args[0];
                    String answer = args[1];

                    flashCards.add(new FlashCard(question, answer));

                    // Get next line
                    line = this.getLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read cards from file.");
            e.printStackTrace();
        }

        return flashCards;
    }
}

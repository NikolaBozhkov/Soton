import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("House config file name not provided.");
        }

        String fileName = args[0];
        House house = null;

        try {
            house = ConfigReader.getHouseFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (house != null) {
            house.go();
        }
    }
}

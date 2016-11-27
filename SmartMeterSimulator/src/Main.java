import java.io.IOException;

/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class Main {
    public static void main(String[] args) {
        House house = null;

        try {
            house = ConfigReader.getHouseFromFile("myHouse.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (house != null) {
            house.go();
        }
    }
}

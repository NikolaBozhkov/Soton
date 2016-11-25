import java.io.IOException;

/**
 * Created by nikolabozhkov on 11/23/16.
 */
public class Main {
    public static void main(String[] args) {
        Appliance electricCooker = new ElectricCooker();
        Appliance boiler = new Boiler();
        Appliance washingMachine = new WashingMachine();

        House house = new House();
        house.addAppliance(electricCooker);
        house.addAppliance(boiler);
        house.addAppliance(washingMachine);

        try {
            ConfigReader.getHouseFromFile("myHouse.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package utils;

import dtos.Food;
import dtos.Fridge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

    static public void fetchFridgeData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("fridge.dat"));

            String s = "";

            while ((s = br.readLine()) != null) {
                String[] buffer = s.split(", ", 6);

                Date expDate = new SimpleDateFormat("dd/MM/yyyy").parse(buffer[5]);

                Food newFood = new Food(
                        buffer[0],
                        buffer[1],
                        Float.parseFloat(buffer[2]),
                        buffer[3],
                        Integer.parseInt(buffer[4]),
                        expDate
                );

                Fridge.addFood(newFood);
            }

            br.close();
        } catch (Exception e) {

        }
    }

    static public void storeFridgeToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("fridge.dat"));

            for (Food f : Fridge.getFoods()) {
                bw.write(f.toString());
            }

            bw.close();
        } catch (Exception e) {
            // Handle exception...
        }

    }
}

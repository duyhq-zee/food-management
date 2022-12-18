package dtos;

import java.util.ArrayList;

public class Fridge {
    static private ArrayList<Food> foods = new ArrayList<>();

    static public void addFood(Food f) {
        foods.add(f);
    }

    static public boolean deleteFood(String foodId) {
        for (int index = 0; index < foods.size(); ++index) {
            if (foods.get(index).getId().equals(foodId)) {
                foods.remove(index);
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Food> getFoods() {
        return foods;
    }
}

package utils;

import dtos.Food;

import java.util.Comparator;

public class FoodComparator implements Comparator<Food> {

    @Override
    public int compare(Food f1, Food f2) {
        if (f1.getExpiredDate().after(f2.getExpiredDate())) {
            return 1;
        } else if (f1.getExpiredDate().before(f2.getExpiredDate())) {
            return -1;
        }

        return 0;
    }
}

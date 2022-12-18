package uis;

import dtos.Food;
import dtos.Fridge;
import utils.DataUtils;
import utils.FoodComparator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("FOOD MANAGEMENT APP");
        DataUtils.fetchFridgeData();
        Scanner sc = new Scanner(System.in);
        String choice = "";

        while (true) {
            System.out.println("1. Add a new food");
            System.out.println("2. Search a food by name");
            System.out.println("3. Remove the food by ID");
            System.out.println("4. Print the food list in the descending order of expired date");
            System.out.println("5. Quit");
            System.out.println("=======");
            System.out.print("Select an option: ");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    boolean cont = false;

                    while (true) {
                        String id = UUID.randomUUID().toString();

                        System.out.print("Name: ");
                        sc = new Scanner(System.in);
                        String name = sc.nextLine();

                        System.out.print("Weight: ");
                        sc = new Scanner(System.in);
                        float weight = sc.nextFloat();

                        System.out.print("Type: ");
                        sc = new Scanner(System.in);
                        String type = sc.nextLine();

                        System.out.print("Place: ");
                        sc = new Scanner(System.in);
                        int place = sc.nextInt();

                        System.out.print("Exp date: ");
                        sc = new Scanner(System.in);
                        String expiredDateStr = sc.nextLine();
                        Date expiredDate = null;

                        try {
                            expiredDate = new SimpleDateFormat("dd/MM/yyyy").parse(expiredDateStr);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        Food newFood = new Food(id, name, weight, type, place, expiredDate);

                        Fridge.addFood(newFood);
                        DataUtils.storeFridgeToFile();

                        System.out.println("Add another food? (Y/N)");
                        sc =  new Scanner(System.in);
                        String input = sc.nextLine();

                        if (input.equalsIgnoreCase("N")) {
                            break;
                        }
                    }

                    break;
                case "2":

                    break;
                case "3":
                    System.out.println("Food's ID you want to delete:");
                    sc = new Scanner(System.in);
                    String deleteId = sc.nextLine();

                    if (Fridge.deleteFood(deleteId)) {
                        System.out.println("Food has been removed!");
                    } else {
                        System.out.println("Food not found! Try again!");
                    }

//                    for (int i = 0; i < Fridge.getFoods().size(); ++i) {
//                        if (Fridge.getFoods().get(i).getId().equals(deleteId)) {
//                            System.out.println("Are you sure? (Y/N)");
//                            sc =  new Scanner(System.in);
//                            String input = sc.nextLine();
//
//                            if (input.equalsIgnoreCase("Y")) {
//                                Fridge.deleteFood(i);
//                                break;
//                            }
//                        }
//                    }

                    DataUtils.storeFridgeToFile();

                    break;
                case "4":
                    ArrayList<Food> sortedFoodList = Fridge.getFoods();

                    sortedFoodList.sort(new FoodComparator());

                    for (Food food : sortedFoodList) {
                        System.out.println(food);
                    }
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

package Pegas.seminar1.task2;

import java.util.Scanner;

public class Program {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UMarket uMarket = new UMarket();
        System.out.println("Welcome to U-Market");
        while (true){
            System.out.println("============================================================");
            System.out.println("0 - finish work with app");
            System.out.println("1 - show list of things");
            System.out.println("2 - create an online shopping cart from snaks");
            System.out.println("3 - create an online shopping cart from semifinichedfood");
            System.out.println("4 - create an online shopping cart from healthyfood");
            System.out.println("5 - create an online shopping cart from any food");
            System.out.println("select a menu item: ");
            if(scanner.hasNextInt()){
                int no = scanner.nextInt();
                scanner.nextLine();
                switch(no){
                    case 0 -> {
                        System.out.println("finishing work with app");
                        return;
                    }
                    case 1 -> {
                        System.out.println("show list of things");
                        uMarket.printThing(Thing.class);
                    }
                    case 2 -> {
                        System.out.println("show list of snaks");
                        uMarket.printThing(Snack.class);
                    }
                    case 3 -> {
                        System.out.println("show list of semifinichedfood");
                        uMarket.printThing(SemiFinishedFood.class);
                    }
                    case 4 -> {
                        System.out.println("show list of healthyfood");
                        uMarket.printThing(HealthyFood.class);
                    }
                    case 5 -> {
                        System.out.println("show list of food");
                        uMarket.printThing(Food.class);
                    }
                }
            }else{
                System.out.println("Uncorrect menu item. \nPlease try again");
            }
        }
    }
}

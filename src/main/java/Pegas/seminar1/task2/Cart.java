package Pegas.seminar1.task2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Cart <T extends Food>{
    @Getter
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(UMarket market, Class<T> clazz) {
        this.foodstuffs = new ArrayList<>();
        this.market = market;
        this.clazz = clazz;
    }

    public void printFoodStuffs(){
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(i->{
                System.out.printf("[%d] %s (Proteins: %s Fats: %s Carbohydrates: %s) \n", index.getAndIncrement(), i.getName(),
                        i.getProteins() ? "Yes" : "No", i.getFats()? "Yes" : "No",
                        i.getCarbohydrates()? "Yes" : "No");
        });
    }
    public void cardBalancing(){
        boolean proteins = checkFlag(Food::getProteins);
        boolean fats = checkFlag(Food::getFats);
        boolean carbonhydrates = checkFlag(Food::getCarbohydrates);

        if(carbonhydrates && fats && proteins){
            System.out.println("Your cart already is balance for PFC");
            return;
        }
        Collection<T> coll = market.getThinds(clazz);
        proteins = checkNutrient(proteins, Food::getProteins, coll);
        fats = checkNutrient(fats, Food::getFats, coll);
        carbonhydrates = checkNutrient(carbonhydrates, Food::getCarbohydrates, coll);

        if(carbonhydrates && fats && proteins){
            System.out.println("Your cart is balance for PFC");

        }else System.out.println("Your cart isn't balance for PFC");

    }
    private boolean checkFlag(Predicate<T> food) {
        Optional<T> check = foodstuffs.stream().filter(food).findFirst();
        return check.isPresent();
    }
    private boolean checkNutrient (boolean flag, Predicate<Food> check, Collection<T> coll) {
        if (!flag) {
            Optional<T> optionalFood = coll.stream()
                    .filter(check)
                    .findFirst();
            optionalFood.ifPresent(foodstuffs::add);
            return optionalFood.isPresent();
        }
        return true;
    }
}

package Pegas.seminar1.task2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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
        boolean proteins = false;
        boolean fats = false;
        boolean carbonhydrates = false;
        for(T i: foodstuffs){
            if(!proteins && i.getProteins()){
                proteins=true;
            } else if (!fats  && i.getFats()) {
                fats = true;
            } else if (!carbonhydrates && i.getCarbohydrates()) {
                carbonhydrates = true;
            }if(carbonhydrates&& fats&& proteins){
                break;
            }
        }
        if(carbonhydrates && fats && proteins){
            System.out.println("Your cart is balance for PFC");
            return;
        }
        for(T i:market.getThinds(clazz)){
            if(!proteins && i.getProteins()){
                proteins=true;
                foodstuffs.add(i);
            } else if (!fats  && i.getFats()) {
                fats = true;
                foodstuffs.add(i);
            } else if (!carbonhydrates && i.getCarbohydrates()) {
                carbonhydrates = true;
                foodstuffs.add(i);
            }if(carbonhydrates&& fats&& proteins){
                break;
            }
        }
        if(carbonhydrates && fats && proteins){
            System.out.println("Your cart is balance for PFC");

        }else System.out.println("Your cart isn't balance for PFC");

    }
}

package Pegas.seminar1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class UMarket {
    private final Collection<Thing> things;

    private void initializeThings(){
        things.add(new Pen());
        things.add(new NoteBook());
        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new BalykCheese());
        things.add(new Chips());
        things.add(new Cheburek());
        things.add(new ChocolateBar());
        things.add(new DumplingsBerries());
        things.add(new DumplingsMeat());
    }

    public UMarket() {
        this.things = new ArrayList<>();
        initializeThings();
    }

    public <T extends Thing> void printThing(Class<T> clazz){
        AtomicInteger index = new AtomicInteger(1);
        things.stream().filter(clazz::isInstance).forEach(i->{
            if(Food.class.isAssignableFrom(i.getClass())){
                   System.out.printf("[%d] %s (Proteins: %s Fats: %s Carbohydrates: %s) \n", index.getAndIncrement(), i.getName(),
                           ((Food) i).getProteins() ? "Yes" : "No", ((Food) i).getFats()? "Yes" : "No",
                           ((Food) i).getCarbohydrates()? "Yes" : "No");
               }else{
                   System.out.printf("[%d] %s\n", index.getAndIncrement(), i.getName());
               }
        });
    }
    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index){
        AtomicInteger counter= new AtomicInteger(1);
        return things.stream().filter(clazz::isInstance)
                .filter(i-> index==counter.getAndIncrement())
                .map(clazz::cast)
                .findFirst().orElse(null);
    }

}

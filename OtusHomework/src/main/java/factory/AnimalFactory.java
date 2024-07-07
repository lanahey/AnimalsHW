package factory;
import animals.Animal;
import animals.birds.Duck;
import animals.pats.Cat;
import animals.pats.Dog;
import data.AnimalInputData;

public class AnimalFactory {

    public Animal create(AnimalInputData animalInputData){
        return switch (animalInputData) {
            case CAT -> new Cat();
            case DOG -> new Dog();
            case DUCK -> new Duck();
        };
    }
}

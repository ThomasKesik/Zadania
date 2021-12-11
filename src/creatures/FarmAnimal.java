package creatures;

public class FarmAnimal extends Animal implements Edible{

    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        setWeight(0.0);
    }
}

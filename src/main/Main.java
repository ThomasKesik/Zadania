package main;

import creatures.Animal;
import creatures.FarmAnimal;
import creatures.Pet;

public class Main {

    public static void main(String[] args) {
        FarmAnimal farmAnimal = new FarmAnimal("Owca");
        Pet pet = new Pet("Pies");

        System.out.println(farmAnimal.getWeight());
        System.out.println(pet.getWeight());

        farmAnimal.beEaten();
        pet.feed(2.3);

        System.out.println(farmAnimal.getWeight());
        System.out.println(pet.getWeight());

        farmAnimal.feed();
        pet.feed();

        System.out.println(farmAnimal.getWeight());
        System.out.println(pet.getWeight());
    }
}

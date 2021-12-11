package creatures;

import interfaces.salable;
import main.Human;

public abstract class Animal implements salable, Feedable{
    public final String species;
    private Double weight;

    public Animal(String species) {
        this.species = species;
        if(this.species == "Pies"){
            this.weight = 20.5;
        } else if (this.species == "Kot"){
            this.weight = 3.4;
        } else {
            this.weight = 15.0;
        }
    }

    @Override
    public void feed(){
        if(weight == 0){
            System.out.println("Nie można karmić zwierzęcia które nie żyje");
        } else {
            this.weight++;
        }
    }

    public void takeForAWalk(){
        if(weight == 0){
            System.out.println("Nie wyprowadzić zwierzęcia które nie żyje");
        } else {
            this.weight--;
            if(this.weight < 0){
                this.weight = 0.0;
            }
        }
    }

    @Override
    public String toString() {
        return "creatures.Animal{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if(seller.pet != null && seller.pet.equals(this)){
            if(buyer.cash >= price){
                seller.cash += price;
                buyer.cash -= price;
                buyer.pet = this;
                seller.pet = null;
                System.out.println("Zwierze " + this.species + " zostało kupione za " + price + " !!!");
            } else {
                System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy by kupić zwierzę !!!");
            }
        } else {
            System.out.println("To zwierzę nie jest twoje !!!");
        }
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public void feed(Double foodWeight) {
        if(weight == 0){
            System.out.println("Nie można karmić zwierzęcia które nie żyje");
        } else {
            this.weight += foodWeight;
        }
    }
}

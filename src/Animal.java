public class Animal {
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
        return "Animal{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                '}';
    }
}

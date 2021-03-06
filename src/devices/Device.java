package devices;

import interfaces.salable;

public abstract class Device implements salable{

    public final String producer;
    public final String model;
    public final Integer yearOfProduction;
    public Double value;

    public Device(String producer, String model, Integer yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    public abstract void turnOn();


    @Override
    public String toString() {
        return super.toString();
    }
}

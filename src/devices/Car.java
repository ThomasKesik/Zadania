package devices;

import java.util.Objects;

public class Car extends Device {

    public final String VIN;
    public Double value;

    public Car(String producer, String model, String VIN,  Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
        this.VIN = VIN;
    }

    @Override
    public void turnOn() {
        System.out.println("Auto zostało włączone");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(producer, car.producer) && Objects.equals(model, car.model) && Objects.equals(VIN, car.VIN) && Objects.equals(yearOfProduction, car.yearOfProduction) && Objects.equals(value, car.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, VIN, yearOfProduction, value);
    }

    @Override
    public String toString() {
        return "devices.Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", VIN='" + VIN + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", value=" + value +
                '}';
    }
}

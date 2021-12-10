package devices;

import java.util.Objects;

public class Car {

    public final String producer;
    public final String model;
    public final String VIN;
    public final Integer productionYear;
    public Double value;


    public Car(String producer, String model, String VIN, Integer productionYear) {
        this.producer = producer;
        this.model = model;
        this.VIN = VIN;
        this.productionYear = productionYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(producer, car.producer) && Objects.equals(model, car.model) && Objects.equals(VIN, car.VIN) && Objects.equals(productionYear, car.productionYear) && Objects.equals(value, car.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, VIN, productionYear, value);
    }

    @Override
    public String toString() {
        return "devices.Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", VIN='" + VIN + '\'' +
                ", productionYear=" + productionYear +
                ", value=" + value +
                '}';
    }
}

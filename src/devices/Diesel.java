package devices;

public class Diesel extends Car{
    public Diesel(String producer, String model, String VIN, Integer yearOfProduction) {
        super(producer, model, VIN, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Zatankowałeś auto olejem napendowym");
    }
}

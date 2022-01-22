package devices;

public class LPG extends Car{
    public LPG(String producer, String model, String VIN, Integer yearOfProduction) {
        super(producer, model, VIN, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Zatankowałeś auto gazem");
    }
}

package devices;

public class Electric extends Car{

    public Electric(String producer, String model, String VIN, Integer yearOfProduction) {
        super(producer, model, VIN, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Naładowałeś auto do 100%");
    }
}

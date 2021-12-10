package devices;

public class Phone extends Device{

    public Phone(String producer, String model, Integer yearOfProduction) {
        super(producer, model, yearOfProduction);
    }

    @Override
    public String toString() {
        return "devices.Phone{}";
    }

    @Override
    public void turnOn() {
        System.out.println("Telefon został włączony");
    }
}

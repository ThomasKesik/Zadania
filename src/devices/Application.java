package devices;

public class Application {

    private String name;
    private String version;
    private Double price;

    public Application(String name, String version, Double price) {
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", price=" + price +
                '}';
    }
}

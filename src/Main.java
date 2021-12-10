public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        Car car = new Car("Skoda", "Octavia", "1J8FFC7Y77D356964", 2000);
        car.value = 100.0;
        human.setCar(car);

        human.setSalary(50.0);
        human.setCar(car);

        human.setSalary(200.0);
        human.setCar(car);
    }
}

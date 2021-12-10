import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Skoda", "Octavia", "1J8FFC7Y77D356964", 2000);
        car1.value = 100.0;

        Car car2 = new Car("Skoda", "Octavia", "1J8FFC7Y77D356964", 2000);
        car2.value = 100.0;

        if(car1.equals(car2)){
            System.out.println("Auta są takie same");
        }

        if(car1.hashCode() == car2.hashCode()){
            System.out.println("Auta są takie same");
        }

        Animal dog = new Animal("Pies");
        System.out.println(dog);

        System.out.println(car1);
        System.out.println(car2);

        Human human = new Human();
        human.setSalary(500.0);
        human.setCar(car1);
        System.out.println(human);

        Phone phone = new Phone("Samsung", "A20", 2015);
        System.out.println(phone);
    }
}

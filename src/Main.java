public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        Car car = new Car("Skoda", "Octavia", "1J8FFC7Y77D356964", 2000);
        human.car = car;

        human.setSalary(-100.0);
        human.getSalary();
        human.getSalary();
        human.setSalary(251.0);
        Double salary = human.getSalary();
        System.out.println(salary);

    }
}

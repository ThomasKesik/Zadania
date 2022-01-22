package excaptions;

public class NoCarInGarageException extends Exception{
    public NoCarInGarageException() {
        super("Sprzedający nie posiada auta w garazu");
        System.out.println("Sprzedający nie posiada auta w garazu");
    }
}
